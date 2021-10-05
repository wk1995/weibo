package com.wk.weibo

import com.wk.base.jar.IProcessStringListener
import com.wk.base.log.WkLog
import org.json.JSONObject
import java.lang.StringBuilder

/**
 *
 *      @author : wk
 *      e-mail : 1226426603@qq.com
 *      time   : 2021/9/20
 *      desc   :
 *      address:
 *      GitHub : https://github.com/wk1995
 *      CSDN   : http://blog.csdn.net/qq_33882671
 *
 */
class AnalysisWeiboAllData : IWeiboDataAnalysis {
    companion object {
        const val TAG = "AnalysisWeiboAllData"
    }


    private val weiboData by lazy {
        StringBuilder()
    }

    private val leftKeys by lazy {
        HashSet<String>()
    }


    override fun processString(string: String, flag: Int): String? {
        if (flag == IProcessStringListener.FLAG_END) {
            WkLog.d(weiboData.toString(), TAG)
            processData()
        } else {
            weiboData.append(string)
        }
        return null
    }

    private fun processData() {
        val json = JSONObject(weiboData.toString())
        val data = json.getJSONObject("data")
        val weiboDataJsonArray = data.getJSONArray("list")
        val dataLength = weiboDataJsonArray.length()
        WkLog.i("weibo data $dataLength", TAG)
        if (dataLength <= 0) {
            return
        }
        val weiboBeans = ArrayList<WeiboBean>()

        for (i in 0 until dataLength) {
            val weiboBeanJsonObject = weiboDataJsonArray.getJSONObject(i)
            weiboBeans.add(processWeiboData(weiboBeanJsonObject))
        }
        WkLog.i("leftkeys: $leftKeys  ${weiboBeans.size}", TAG)
        weiboBeans.forEach {
            WkLog.i("weiboBean: ${it.mid}", TAG)
        }
    }

    private fun processWeiboData(weiboBeanJsonObject: JSONObject): WeiboBean {
        val keys = weiboBeanJsonObject.keySet()
        val weiboBeanClass = WeiboBean::class.java
        val weiboBeanFields = weiboBeanClass.declaredFields
        val weiboBean = weiboBeanClass.newInstance()
        weiboBeanFields.forEach {
            val key = it.name
            if (keys.contains(key)) {
                it.isAccessible = true
                if(key=="retweeted_status") {
                    val reweibo=processWeiboData(weiboBeanJsonObject.getJSONObject(key) )
                    it.set(weiboBean, reweibo)
                }else{
                    it.set(weiboBean, weiboBeanJsonObject.get(key))
                }
                keys.remove(key)
            }
        }
        leftKeys.addAll(keys)
        return weiboBean
    }

}