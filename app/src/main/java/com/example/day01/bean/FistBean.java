package com.example.day01.bean;

import java.io.Serializable;
import java.util.List;

public class FistBean {

    /**
     * message : 请求ii成功
     * code : 200
     * news : [{"tile":"积云教育第12月考","content":"积云教育考试12月11号开始考试，本次考试内容很丰富，有POP有MVP有数据库等一些列知识点，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14937214454750141.jpg"},{"tile":"积云教育第11月考","content":"积云教育考试11月15号开始考试，考试内容有网络请求等，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14938873919030679.jpg"},{"tile":"积云教育第10月考","content":"积云教育考试10月05号开始考试，考试内容有视频播放，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14943267735961674.jpg"},{"tile":"积云教育第09月考","content":"积云教育考试09月03号开始考试，考试内容Webview等网页展示，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14939843143621089.jpg"},{"tile":"积云教育第08月考","content":"积云教育考试08月06号开始考试，考试内容TextView、EditText，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14938092956370380.jpg"},{"tile":"积云教育第07月考","content":"积云教育考试07月06号开始考试，考试内容ImageView，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14937214454750141.jpg"},{"tile":"积云教育第06月考","content":"积云教育考试06月07号开始考试，考试内容有RecycleView的多布局展示，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14931970965550315.jpg"},{"tile":"积云教育第05月考","content":"积云教育考试05月08号开始考试，考试内容有二级列表展示，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14938873919030679.jpg"},{"tile":"积云教育第04月考","content":"积云教育考试04月09号开始考试，考试内容网络请求、数据展示等，物联网组织学生复习","imageUrl":"https://yanxuan.nosdn.127.net/14937214454750141.jpg"}]
     */

    private String message;
    private String code;
    private List<NewsBean> news;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class NewsBean implements Serializable {
        /**
         * tile : 积云教育第12月考
         * content : 积云教育考试12月11号开始考试，本次考试内容很丰富，有POP有MVP有数据库等一些列知识点，物联网组织学生复习
         * imageUrl : https://yanxuan.nosdn.127.net/14937214454750141.jpg
         */

        private String tile;
        private String content;
        private String imageUrl;

        public String getTile() {
            return tile;
        }

        public void setTile(String tile) {
            this.tile = tile;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
