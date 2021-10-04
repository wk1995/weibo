package com.wk.weibo;

import com.wk.base.jar.net.NetConnection;

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
        NetConnection.INSTANCE
                .setUrl(WeiboUrls.WEIBO_DELETE_WEIBO)
                .setRequestMethod(REQUEST_METHOD_TYPE_POST)
                .addRequestBody("mid","3924795773076474")
                .addRequestBody("Cookie","SINAGLOBAL=316779511826.86346.1562978858977; wvr=6; wb_timefeed_5475063233=1; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WW1.WNu87Bow19hU6NJ8OuI5JpX5KMhUgL.Fo-XS0-7SoeEe0e2dJLoIEXLxKqLBKzLBKqLxKqL1heLBoeLxKML1-2L1hBLxKnLB.BLB-eLxKnLBKML1Kzt; UOR=,,login.sina.com.cn; ALF=1663802782; SSOLoginState=1632266783; SCF=AgS7HUq4ILlJvJQRVKtecHqsoczVgGuDwbED_caHU_XH7Eq0ZMfRjYwSlXYlgRXhkS3aUPrxi6tqOH-odUbNx4A.; SUB=_2A25MThpODeRhGeNK7FcR9i3OyD-IHXVvOgyGrDV8PUNbmtCOLU-jkW9NSTcKZBwrGx31LHpi3FPCVEPipyeI4Hce; _s_tentry=login.sina.com.cn; Apache=650066232359.4941.1632266788309; wb_view_log_5475063233=1920*10801; ULV=1632266788329:149:23:7:650066232359.4941.1632266788309:1632227777686; webim_unReadCount=%7B%22time%22%3A1632267680698%2C%22dm_pub_total%22%3A0%2C%22chat_group_client%22%3A0%2C%22chat_group_notice%22%3A0%2C%22allcountNum%22%3A0%2C%22msgbox%22%3A0%7D")
                .setIProcessStringListener(new AnalysisWeiboAllData())
                .connectUrl();
    }

}
