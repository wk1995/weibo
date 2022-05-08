package com.wk.weibo

import com.wk.base.jar.IProcessStringListener
import com.wk.base.log.WkLog
import java.lang.StringBuilder

/**
 *
 *      @author : wk
 *      e-mail : 1226426603@qq.com
 *      time   : 2021/10/4
 *      desc   :
 *      address:
 *      GitHub : https://github.com/wk1995
 *      CSDN   : http://blog.csdn.net/qq_33882671
 *
 */
class AnalysisWeiboDeleteData: IWeiboDataAnalysis {
    private val weiboData by lazy {
        StringBuilder()
    }
    override fun processString(string: String, flag: Int, what: Int): String? {
        if (flag == IProcessStringListener.FLAG_END) {
            WkLog.d(weiboData.toString(), AnalysisWeiboAllData.TAG)
        } else {
            weiboData.append(string)
        }
        return null
    }
}