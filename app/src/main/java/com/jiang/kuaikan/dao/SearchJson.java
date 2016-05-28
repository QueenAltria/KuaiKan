package com.jiang.kuaikan.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class SearchJson {

    /**
     * code : 200
     * data : {"topics":[{"comics_count":36,"comments_count":775002,"cover_image_url":"http://i.kuaikanmanhua.com/image/160525/wnamh09of.webp-w640","created_at":1442563580,"description":"一个长相普通的职场女青年，无意中下载了一个整容APP...初尝了变美的禁果，从此踏上了一条不归路\u2014\u2014【独家/每周六更新  责编：Nico】","discover_image_url":null,"id":544,"is_favourite":false,"label_id":17,"likes_count":12331620,"order":100,"title":"整容游戏","updated_at":1442563580,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180","grade":1,"id":2967943,"nickname":"金丘","reg_type":"author"},"user_id":2967943,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160525/fw0n148vi.webp-w320"},{"comics_count":7,"comments_count":12151,"cover_image_url":"http://i.kuaikanmanhua.com/image/150725/n0n122eil.jpg-w640","created_at":1437822193,"description":"醒来发现自己在一间密室里，我该如何逃离出去呢~？【授权/暂停更新  责编：奶片侠】","discover_image_url":null,"id":428,"is_favourite":false,"label_id":8,"likes_count":222522,"order":0,"title":"心理游戏实验室","updated_at":1437822193,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/150725/l069hedwu.jpg-w180","grade":1,"id":1419050,"nickname":"火京灵+黎色","reg_type":"author"},"user_id":1419050,"vertical_image_url":"http://i.kuaikanmanhua.com/image/150725/syz07a6z9.jpg-w320"}]}
     * message : OK
     */

    private int code;
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
        /**
         * comics_count : 36
         * comments_count : 775002
         * cover_image_url : http://i.kuaikanmanhua.com/image/160525/wnamh09of.webp-w640
         * created_at : 1442563580
         * description : 一个长相普通的职场女青年，无意中下载了一个整容APP...初尝了变美的禁果，从此踏上了一条不归路——【独家/每周六更新  责编：Nico】
         * discover_image_url : null
         * id : 544
         * is_favourite : false
         * label_id : 17
         * likes_count : 12331620
         * order : 100
         * title : 整容游戏
         * updated_at : 1442563580
         * user : {"avatar_url":"http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180","grade":1,"id":2967943,"nickname":"金丘","reg_type":"author"}
         * user_id : 2967943
         * vertical_image_url : http://i.kuaikanmanhua.com/image/160525/fw0n148vi.webp-w320
         */

        private List<TopicsBean> topics;

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public static class TopicsBean {
            private int comics_count;
            private int comments_count;
            private String cover_image_url;
            private int created_at;
            private String description;
            private Object discover_image_url;
            private int id;
            private boolean is_favourite;
            private int label_id;
            private int likes_count;
            private int order;
            private String title;
            private int updated_at;
            /**
             * avatar_url : http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180
             * grade : 1
             * id : 2967943
             * nickname : 金丘
             * reg_type : author
             */

            private UserBean user;
            private int user_id;
            private String vertical_image_url;

            public int getComics_count() {
                return comics_count;
            }

            public void setComics_count(int comics_count) {
                this.comics_count = comics_count;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
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

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
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

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
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

            public static class UserBean {
                private String avatar_url;
                private int grade;
                private int id;
                private String nickname;
                private String reg_type;

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
            }
        }
    }
}
