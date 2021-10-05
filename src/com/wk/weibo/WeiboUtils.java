package com.wk.weibo;

import com.wk.base.jar.net.NetConnection;

import java.io.UnsupportedEncodingException;

import static com.wk.base.jar.net.NetConnection.REQUEST_METHOD_TYPE_POST;

/**
 * @author : wk
 * e-mail : 1226426603@qq.com <
 * time   : 2021/9/19
 * desc   :
 * address:
 * GitHub : https://github.com/wk1995
 * CSDN   : http://blog.csdn.net/qq_33882671
 */
public class WeiboUtils {

    public static void queryALLWeibo() {
        NetConnection.INSTANCE
                .setUrl(WeiboUrls.QUERY_ALL_WEIBO_NEW)
                .setIProcessStringListener(new AnalysisWeiboAllData())
                .addRequestProperty("Cookie","SINAGLOBAL=316779511826.86346.1562978858977; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WW1.WNu87Bow19hU6NJ8OuI5JpX5KMhUgL.Fo-XS0-7SoeEe0e2dJLoIEXLxKqLBKzLBKqLxKqL1heLBoeLxKML1-2L1hBLxKnLB.BLB-eLxKnLBKML1Kzt; UOR=,,www.cnblogs.com; WBPSESS=JVbBeBpD8mOLGR_cKaHrXNS6qVAdKOS5bOTGjnPUHt9hQxZxiyzX2LmDwPmsVcGtckVtcMb718F_R812A33L_KnxsVRDd9hT0XQeMS1KuKhEbEYphPR_2jjea2tfrwvO; ALF=1664862632; SSOLoginState=1633326632; SCF=AgS7HUq4ILlJvJQRVKtecHqsoczVgGuDwbED_caHU_XHYQbYmQDSfiujwIG7wp0Lbyd225Q-eOpakPBPK0Vr2SI.; SUB=_2A25MXuZ4DeRhGeNK7FcR9i3OyD-IHXVvKlCwrDV8PUNbmtANLWjGkW9NSTcKZFmVVmp1M7RQbJNqLUCIbL1dVyZJ; XSRF-TOKEN=WQQ_6SxTZE34Lxgk3-prvjFy; _s_tentry=-; Apache=8989475668495.62.1633336461973; ULV=1633336462029:159:1:1:8989475668495.62.1633336461973:1633001711891")
                .connectUrl();
    }

    public static void deleteWeibo(String mid){
        try {
            StringBuilder postData = new StringBuilder();
            postData.append('&');
            postData.append("id");
            postData.append('=');
            postData.append(mid);
            NetConnection.INSTANCE
                    .setUrl(WeiboUrls.WEIBO_DELETE_WEIBO_NEW)
                    .setRequestMethod(REQUEST_METHOD_TYPE_POST)
                    .addRequestProperty("accept-language", "zh-CN,zh;q=0.9")
                    .addRequestProperty("accept", "application/json, text/plain, */*")
                    .addRequestProperty("accept-encoding", "gzip, deflate, br")
                    .addRequestProperty("content-type", "application/json;charset=UTF-8")
                    .addRequestProperty("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"")
                    .addRequestProperty("sec-ch-ua-mobile", "?0")
                    .addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36")
                    .addRequestProperty("sec-fetch-dest", "empty")
                    .addRequestProperty("sec-fetch-mode", "cors")
                    .addRequestProperty("sec-fetch-site", "same-origin")
                    .addRequestProperty("traceparent", "00-639579f375545b39d139887691f39fe2-45f21271188aa391-00")
                    .addRequestProperty("x-requested-with", "XMLHttpRequest")
                    .addRequestProperty("origin", "https://weibo.com")
                    .addRequestProperty("x-xsrf-token", "WQQ_6SxTZE34Lxgk3-prvjFy")
                    .addRequestProperty("referer", "https://weibo.com/u/5475063233")
                    .addRequestProperty("traceparent", "00-639579f375545b39d139887691f39fe2-45f21271188aa391-00")
//                .addRequestProperty(":method","POST")
//                .addRequestProperty(":authority","weibo.com")
//                .addRequestProperty(":path","/ajax/statuses/destroy")
//                .addRequestProperty(":scheme","https")
                    .setPostMessage(postData.toString().getBytes("UTF-8"))
                    .addRequestProperty("cookie", "SINAGLOBAL=316779511826.86346.1562978858977; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WW1.WNu87Bow19hU6NJ8OuI5JpX5KMhUgL.Fo-XS0-7SoeEe0e2dJLoIEXLxKqLBKzLBKqLxKqL1heLBoeLxKML1-2L1hBLxKnLB.BLB-eLxKnLBKML1Kzt; UOR=,,www.cnblogs.com; WBPSESS=JVbBeBpD8mOLGR_cKaHrXNS6qVAdKOS5bOTGjnPUHt9hQxZxiyzX2LmDwPmsVcGtckVtcMb718F_R812A33L_KnxsVRDd9hT0XQeMS1KuKhEbEYphPR_2jjea2tfrwvO; ALF=1664862632; SSOLoginState=1633326632; SCF=AgS7HUq4ILlJvJQRVKtecHqsoczVgGuDwbED_caHU_XHYQbYmQDSfiujwIG7wp0Lbyd225Q-eOpakPBPK0Vr2SI.; SUB=_2A25MXuZ4DeRhGeNK7FcR9i3OyD-IHXVvKlCwrDV8PUNbmtANLWjGkW9NSTcKZFmVVmp1M7RQbJNqLUCIbL1dVyZJ; XSRF-TOKEN=WQQ_6SxTZE34Lxgk3-prvjFy; _s_tentry=-; Apache=8989475668495.62.1633336461973; ULV=1633336462029:159:1:1:8989475668495.62.1633336461973:1633001711891")
                    .setIProcessStringListener(new AnalysisWeiboDeleteData())
                    .connectUrl();
        }catch (UnsupportedEncodingException e){

        }
    }

}
