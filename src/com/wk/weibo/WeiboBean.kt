package com.wk.weibo

import com.wk.base.jar.NumberConstants
import com.wk.base.jar.StringConstants
import com.wk.base.jar.SuppressConstant
import com.wk.base.jar.annotation.FiledExplication

/**
 *
 *      @author : wk
 *      e-mail : 1226426603@qq.com
 *      time   : 2021/9/21
 *      desc   : 微博实体类
 *      address:
 *      GitHub : https://github.com/wk1995
 *      CSDN   : http://blog.csdn.net/qq_33882671
 *
 */
@Suppress(SuppressConstant.UNUSED)
class WeiboBean {

    companion object {
        const val FILED_EXPLICATION_CONSTANT_CREATED_AT = "发布时间"
        const val FILED_EXPLICATION_CONSTANT_TEXT_RAW = "博文正文文字数据"
    }

    var visible: Any? = null
    /**
     * 发布时间
     * */
    @FiledExplication(FILED_EXPLICATION_CONSTANT_CREATED_AT)
    var created_at: String = StringConstants.STR_EMPTY

    var id: Long = NumberConstants.NUMBER_LONG_ONE_NEGATIVE

    var idstr: String = NumberConstants.NUMBER_LONG_ONE_NEGATIVE.toString()

    var mid: String = StringConstants.STR_EMPTY

    var mblogid: String = StringConstants.STR_EMPTY

    var user: Any? = null

    var can_edit: Boolean = false

    /**博文正文文字数据*/
    @FiledExplication(FILED_EXPLICATION_CONSTANT_TEXT_RAW)
    var text_raw: String = StringConstants.STR_EMPTY
    /**
     * 包含跳转的一些字符串</a>
     * */
    var text: String = StringConstants.STR_EMPTY

    var textLength: Int = NumberConstants.NUMBER_INT_ZERO

    /**发布来源*/
    var source: String = StringConstants.STR_EMPTY

    var favorited: Boolean = false

    var rid: String = StringConstants.STR_EMPTY

    /**阅读量*/
    var reads_count: Int = NumberConstants.NUMBER_INT_ZERO
    /**todo 实体类*/
    var pic_ids: Any? = null
    var geo: Any? = null

    var pic_num: Int = NumberConstants.NUMBER_INT_ZERO

    var is_paid: Boolean = false

    var mblog_vip_type: Int = NumberConstants.NUMBER_INT_ZERO
    /**todo 实体类*/
    var number_display_strategy: Any? = null

    /**转发数量(超过100万的只会显示100万)*/
    var reposts_count: Int = NumberConstants.NUMBER_INT_ZERO

    /**评论数量(超过100万的只会显示100万)*/
    var comments_count: Int = NumberConstants.NUMBER_INT_ZERO


    /**点赞数量*/
    var attitudes_count: Int = NumberConstants.NUMBER_INT_ZERO
    var attitudes_status: Int = NumberConstants.NUMBER_INT_ZERO

    var isLongText: Boolean = false

    var mlevel: Int = NumberConstants.NUMBER_INT_ZERO
    var content_auth: Int = NumberConstants.NUMBER_INT_ZERO
    var is_show_bulletin: Int = NumberConstants.NUMBER_INT_ZERO

    /**todo 实体类*/
    var comment_manage_info: Any? = null

    var share_repost_type: Int = NumberConstants.NUMBER_INT_ZERO
    /**todo 实体类*/
    var title: Any? = null
    var mblogtype: Int = NumberConstants.NUMBER_INT_ZERO
    var showFeedRepost: Boolean = false
    var showFeedComment: Boolean = false

    /**todo 实体类*/
    var rcList: Any? = null

    /**todo 实体类*/
    var retweeted_status: WeiboBean? = null


    fun isInValid():Boolean{
       return retweeted_status?.text_raw?.startsWith("根据博主设置，此内容无法访问")==true
               || retweeted_status?.text_raw?.startsWith("抱歉，此微博已被作者删除。查看帮助")==true
               || retweeted_status?.text_raw?.startsWith("抱歉，作者已设置仅展示半年内微博，此微博已不可见")==true
               || retweeted_status?.retweeted_status?.isInValid()!=true
    }
}