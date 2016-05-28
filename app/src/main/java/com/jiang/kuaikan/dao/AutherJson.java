package com.jiang.kuaikan.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class AutherJson {

    /**
     * code : 200
     * data : {"avatar_url":"http://i.kuaikanmanhua.com/image/160203/sz37z2mh6.webp-w180.w","grade":1,"id":6957622,"intro":"夏天岛签约作者，漫画：叨叨君 编剧：通幽","nickname":"通幽/夏天岛+叨叨君/夏天岛","reg_type":"author","topics":[{"comics_count":15,"cover_image_url":"http://i.kuaikanmanhua.com/image/160202/a3ljbucwd.webp-w750","created_at":1454393227,"description":"山里长大的小狐妖第一次进城，因种种事故被一富二代收养，不会照顾人的富二代和未经世事的小狐妖会碰撞出怎样的故事？【独家/每周一更新 责编：林早上】","discover_image_url":null,"id":711,"is_favourite":false,"label_id":23,"order":300,"title":"捡到只小狐狸","updated_at":1454393227,"user_id":6957622,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160202/nf1ghze1c.webp-w320.w"}],"update_remind_flag":1,"weibo":"http://weibo.com/u/2017100943 http://weibo.com/chocolate9290","weibo_name":"通幽幽 叨叨君_","works":"《捡到只小狐狸》"}
     * message : OK
     */

    private int code;
    /**
     * avatar_url : http://i.kuaikanmanhua.com/image/160203/sz37z2mh6.webp-w180.w
     * grade : 1
     * id : 6957622
     * intro : 夏天岛签约作者，漫画：叨叨君 编剧：通幽
     * nickname : 通幽/夏天岛+叨叨君/夏天岛
     * reg_type : author
     * topics : [{"comics_count":15,"cover_image_url":"http://i.kuaikanmanhua.com/image/160202/a3ljbucwd.webp-w750","created_at":1454393227,"description":"山里长大的小狐妖第一次进城，因种种事故被一富二代收养，不会照顾人的富二代和未经世事的小狐妖会碰撞出怎样的故事？【独家/每周一更新 责编：林早上】","discover_image_url":null,"id":711,"is_favourite":false,"label_id":23,"order":300,"title":"捡到只小狐狸","updated_at":1454393227,"user_id":6957622,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160202/nf1ghze1c.webp-w320.w"}]
     * update_remind_flag : 1
     * weibo : http://weibo.com/u/2017100943 http://weibo.com/chocolate9290
     * weibo_name : 通幽幽 叨叨君_
     * works : 《捡到只小狐狸》
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private String avatar_url;
        private int grade;
        private int id;
        private String intro;
        private String nickname;
        private String reg_type;
        private int update_remind_flag;
        private String weibo;
        private String weibo_name;
        private String works;
        /**
         * comics_count : 15
         * cover_image_url : http://i.kuaikanmanhua.com/image/160202/a3ljbucwd.webp-w750
         * created_at : 1454393227
         * description : 山里长大的小狐妖第一次进城，因种种事故被一富二代收养，不会照顾人的富二代和未经世事的小狐妖会碰撞出怎样的故事？【独家/每周一更新 责编：林早上】
         * discover_image_url : null
         * id : 711
         * is_favourite : false
         * label_id : 23
         * order : 300
         * title : 捡到只小狐狸
         * updated_at : 1454393227
         * user_id : 6957622
         * vertical_image_url : http://i.kuaikanmanhua.com/image/160202/nf1ghze1c.webp-w320.w
         */

        private List<TopicsBean> topics;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReg_type() {
            return reg_type;
        }

        public void setReg_type(String reg_type) {
            this.reg_type = reg_type;
        }

        public int getUpdate_remind_flag() {
            return update_remind_flag;
        }

        public void setUpdate_remind_flag(int update_remind_flag) {
            this.update_remind_flag = update_remind_flag;
        }

        public String getWeibo() {
            return weibo;
        }

        public void setWeibo(String weibo) {
            this.weibo = weibo;
        }

        public String getWeibo_name() {
            return weibo_name;
        }

        public void setWeibo_name(String weibo_name) {
            this.weibo_name = weibo_name;
        }

        public String getWorks() {
            return works;
        }

        public void setWorks(String works) {
            this.works = works;
        }

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public static class TopicsBean {
            private int comics_count;
            private String cover_image_url;
            private int created_at;
            private String description;
            private Object discover_image_url;
            private int id;
            private boolean is_favourite;
            private int label_id;
            private int order;
            private String title;
            private int updated_at;
            private int user_id;
            private String vertical_image_url;

            public int getComics_count() {
                return comics_count;
            }

            public void setComics_count(int comics_count) {
                this.comics_count = comics_count;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getDiscover_image_url() {
                return discover_image_url;
            }

            public void setDiscover_image_url(Object discover_image_url) {
                this.discover_image_url = discover_image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIs_favourite() {
                return is_favourite;
            }

            public void setIs_favourite(boolean is_favourite) {
                this.is_favourite = is_favourite;
            }

            public int getLabel_id() {
                return label_id;
            }

            public void setLabel_id(int label_id) {
                this.label_id = label_id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getVertical_image_url() {
                return vertical_image_url;
            }

            public void setVertical_image_url(String vertical_image_url) {
                this.vertical_image_url = vertical_image_url;
            }
        }
    }
}
