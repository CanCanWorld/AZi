package com.zrq.azi.bean;

import java.util.List;

public class DailyList {

    private int code;
    private boolean featureFirst;
    private boolean haveRcmdSongs;
    private List<RecommendBean> recommend;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFeatureFirst() {
        return featureFirst;
    }

    public void setFeatureFirst(boolean featureFirst) {
        this.featureFirst = featureFirst;
    }

    public boolean isHaveRcmdSongs() {
        return haveRcmdSongs;
    }

    public void setHaveRcmdSongs(boolean haveRcmdSongs) {
        this.haveRcmdSongs = haveRcmdSongs;
    }

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public static class RecommendBean {
        private long id;
        private long type;
        private String name;
        private String copywriter;
        private String picUrl;
        private long playcount;
        private long createTime;
        private CreatorBean creator;
        private long trackCount;
        private long userId;
        private String alg;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getType() {
            return type;
        }

        public void setType(long type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCopywriter() {
            return copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public long getPlaycount() {
            return playcount;
        }

        public void setPlaycount(long playcount) {
            this.playcount = playcount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public long getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(long trackCount) {
            this.trackCount = trackCount;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public static class CreatorBean {
            private boolean mutual;
            private Object remarkName;
            private String backgroundImgIdStr;
            private long avatarImgId;
            private long backgroundImgId;
            private String detailDescription;
            private boolean defaultAvatar;
            private Object expertTags;
            private long djStatus;
            private boolean followed;
            private String backgroundUrl;
            private String avatarImgIdStr;
            private long userId;
            private long accountStatus;
            private long vipType;
            private long province;
            private String avatarUrl;
            private long authStatus;
            private long userType;
            private String nickname;
            private long gender;
            private long birthday;
            private long city;
            private String description;
            private String signature;
            private long authority;

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public long getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(long djStatus) {
                this.djStatus = djStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public long getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(long accountStatus) {
                this.accountStatus = accountStatus;
            }

            public long getVipType() {
                return vipType;
            }

            public void setVipType(long vipType) {
                this.vipType = vipType;
            }

            public long getProvince() {
                return province;
            }

            public void setProvince(long province) {
                this.province = province;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public long getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(long authStatus) {
                this.authStatus = authStatus;
            }

            public long getUserType() {
                return userType;
            }

            public void setUserType(long userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public long getGender() {
                return gender;
            }

            public void setGender(long gender) {
                this.gender = gender;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public long getCity() {
                return city;
            }

            public void setCity(long city) {
                this.city = city;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public long getAuthority() {
                return authority;
            }

            public void setAuthority(long authority) {
                this.authority = authority;
            }
        }
    }
}
