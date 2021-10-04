package com.wk.weibo

import com.wk.base.jar.NumberConstants
import com.wk.base.jar.StringConstants

/**
 *
 *      @author : wk
 *      e-mail : 1226426603@qq.com
 *      time   : 2021/10/4
 *      desc   : 微博用户实体类
 *      address:
 *      GitHub : https://github.com/wk1995
 *      CSDN   : http://blog.csdn.net/qq_33882671
 *
 */
class WeiBoUserBean {


    private var id:Long= NumberConstants.NUMBER_LONG_ONE_NEGATIVE

    private var idstr:String= NumberConstants.NUMBER_LONG_ONE_NEGATIVE.toString()


    private var pc_new:Int=NumberConstants.NUMBER_INT_ZERO

    private var screen_name:String=StringConstants.STR_EMPTY

    /**头像*/
    private var profile_image_url:String=StringConstants.STR_EMPTY


    private var profile_url:String=StringConstants.STR_EMPTY

    private var verified:Boolean=false

    private var verified_type:Long= NumberConstants.NUMBER_LONG_ONE_NEGATIVE

    private var domain:String=StringConstants.STR_EMPTY
    private var weihao:String=StringConstants.STR_EMPTY
    /**头像 大图地址*/
    private var avatar_large:String=StringConstants.STR_EMPTY
    /**头像 大图地址*/
    private var avatar_hd:String=StringConstants.STR_EMPTY
    private var follow_me:Boolean=false
    private var following:Boolean=false

    private var mbrank:Int=NumberConstants.NUMBER_INT_ZERO
    private var mbtype:Int=NumberConstants.NUMBER_INT_ZERO

    private var planet_video:Boolean=false





}