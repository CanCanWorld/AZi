package com.zrq.azi.bean;

import androidx.annotation.Keep;

import java.util.ArrayList;
import java.util.List;

@Keep
public class UserPlayList{

    private String version;
    private boolean more;
    private ArrayList<PlaylistDTO> playlist;
    private long code;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public ArrayList<PlaylistDTO> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<PlaylistDTO> playlist) {
        this.playlist = playlist;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public static class PlaylistDTO {
        private String songGson;
        private long _id;
        private List<?> subscribers;
        private boolean subscribed;
        private CreatorDTO creator;
        private Object artists;
        private Object tracks;
        private Object updateFrequency;
        private long backgroundCoverId;
        private Object backgroundCoverUrl;
        private long titleImage;
        private Object titleImageUrl;
        private Object englishTitle;
        private boolean opRecommend;
        private Object recommendInfo;
        private long subscribedCount;
        private long cloudTrackCount;
        private long userId;
        private long totalDuration;
        private long coverImgId;
        private long privacy;
        private long trackUpdateTime;
        private long trackCount;
        private long updateTime;
        private String commentThreadId;
        private String coverImgUrl;
        private long specialType;
        private boolean anonimous;
        private long createTime;
        private boolean highQuality;
        private boolean newImported;
        private long trackNumberUpdateTime;
        private long playCount;
        private long adType;
        private String description;
        private List<String> tags;
        private boolean ordered;
        private long status;
        private String name;
        private long id;
        private String coverImgId_str;
        private Object sharedUsers;
        private Object shareStatus;
        private boolean copied;


        public void setSongGson(String songGson) {
            this.songGson = songGson;
        }

        public String getSongGson() {
            return songGson;
        }

        public void set_id(long _id) {
            this._id = _id;
        }

        public long get_id() {
            return _id;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorDTO getCreator() {
            return creator;
        }

        public void setCreator(CreatorDTO creator) {
            this.creator = creator;
        }

        public Object getArtists() {
            return artists;
        }

        public void setArtists(Object artists) {
            this.artists = artists;
        }

        public Object getTracks() {
            return tracks;
        }

        public void setTracks(Object tracks) {
            this.tracks = tracks;
        }

        public Object getUpdateFrequency() {
            return updateFrequency;
        }

        public void setUpdateFrequency(Object updateFrequency) {
            this.updateFrequency = updateFrequency;
        }

        public long getBackgroundCoverId() {
            return backgroundCoverId;
        }

        public void setBackgroundCoverId(long backgroundCoverId) {
            this.backgroundCoverId = backgroundCoverId;
        }

        public Object getBackgroundCoverUrl() {
            return backgroundCoverUrl;
        }

        public void setBackgroundCoverUrl(Object backgroundCoverUrl) {
            this.backgroundCoverUrl = backgroundCoverUrl;
        }

        public long getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(long titleImage) {
            this.titleImage = titleImage;
        }

        public Object getTitleImageUrl() {
            return titleImageUrl;
        }

        public void setTitleImageUrl(Object titleImageUrl) {
            this.titleImageUrl = titleImageUrl;
        }

        public Object getEnglishTitle() {
            return englishTitle;
        }

        public void setEnglishTitle(Object englishTitle) {
            this.englishTitle = englishTitle;
        }

        public boolean isOpRecommend() {
            return opRecommend;
        }

        public void setOpRecommend(boolean opRecommend) {
            this.opRecommend = opRecommend;
        }

        public Object getRecommendInfo() {
            return recommendInfo;
        }

        public void setRecommendInfo(Object recommendInfo) {
            this.recommendInfo = recommendInfo;
        }

        public long getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(long subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public long getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(long cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(long totalDuration) {
            this.totalDuration = totalDuration;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public long getPrivacy() {
            return privacy;
        }

        public void setPrivacy(long privacy) {
            this.privacy = privacy;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public long getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(long trackCount) {
            this.trackCount = trackCount;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public long getSpecialType() {
            return specialType;
        }

        public void setSpecialType(long specialType) {
            this.specialType = specialType;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public long getAdType() {
            return adType;
        }

        public void setAdType(long adType) {
            this.adType = adType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCoverImgId_str() {
            return coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public Object getSharedUsers() {
            return sharedUsers;
        }

        public void setSharedUsers(Object sharedUsers) {
            this.sharedUsers = sharedUsers;
        }

        public Object getShareStatus() {
            return shareStatus;
        }

        public void setShareStatus(Object shareStatus) {
            this.shareStatus = shareStatus;
        }

        public boolean isCopied() {
            return copied;
        }

        public void setCopied(boolean copied) {
            this.copied = copied;
        }

        public static class CreatorDTO {
            private boolean defaultAvatar;
            private long province;
            private long authStatus;
            private boolean followed;
            private String avatarUrl;
            private long accountStatus;
            private long gender;
            private long city;
            private long birthday;
            private long userId;
            private long userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private long authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private long djStatus;
            private long vipType;
            private Object remarkName;
            private long authenticationTypes;
            private Object avatarDetail;
            private boolean anchor;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public long getProvince() {
                return province;
            }

            public void setProvince(long province) {
                this.province = province;
            }

            public long getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(long authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public long getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(long accountStatus) {
                this.accountStatus = accountStatus;
            }

            public long getGender() {
                return gender;
            }

            public void setGender(long gender) {
                this.gender = gender;
            }

            public long getCity() {
                return city;
            }

            public void setCity(long city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
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

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
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

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public long getAuthority() {
                return authority;
            }

            public void setAuthority(long authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public long getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(long djStatus) {
                this.djStatus = djStatus;
            }

            public long getVipType() {
                return vipType;
            }

            public void setVipType(long vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public long getAuthenticationTypes() {
                return authenticationTypes;
            }

            public void setAuthenticationTypes(long authenticationTypes) {
                this.authenticationTypes = authenticationTypes;
            }

            public Object getAvatarDetail() {
                return avatarDetail;
            }

            public void setAvatarDetail(Object avatarDetail) {
                this.avatarDetail = avatarDetail;
            }

            public boolean isAnchor() {
                return anchor;
            }

            public void setAnchor(boolean anchor) {
                this.anchor = anchor;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        @Override
        public String toString() {
            return "PlaylistDTO{" +
                    "songGson='" + songGson + '\'' +
                    ", _id=" + _id +
                    ", subscribers=" + subscribers +
                    ", subscribed=" + subscribed +
                    ", creator=" + creator +
                    ", artists=" + artists +
                    ", tracks=" + tracks +
                    ", updateFrequency=" + updateFrequency +
                    ", backgroundCoverId=" + backgroundCoverId +
                    ", backgroundCoverUrl=" + backgroundCoverUrl +
                    ", titleImage=" + titleImage +
                    ", titleImageUrl=" + titleImageUrl +
                    ", englishTitle=" + englishTitle +
                    ", opRecommend=" + opRecommend +
                    ", recommendInfo=" + recommendInfo +
                    ", subscribedCount=" + subscribedCount +
                    ", cloudTrackCount=" + cloudTrackCount +
                    ", userId=" + userId +
                    ", totalDuration=" + totalDuration +
                    ", coverImgId=" + coverImgId +
                    ", privacy=" + privacy +
                    ", trackUpdateTime=" + trackUpdateTime +
                    ", trackCount=" + trackCount +
                    ", updateTime=" + updateTime +
                    ", commentThreadId='" + commentThreadId + '\'' +
                    ", coverImgUrl='" + coverImgUrl + '\'' +
                    ", specialType=" + specialType +
                    ", anonimous=" + anonimous +
                    ", createTime=" + createTime +
                    ", highQuality=" + highQuality +
                    ", newImported=" + newImported +
                    ", trackNumberUpdateTime=" + trackNumberUpdateTime +
                    ", playCount=" + playCount +
                    ", adType=" + adType +
                    ", description='" + description + '\'' +
                    ", tags=" + tags +
                    ", ordered=" + ordered +
                    ", status=" + status +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", coverImgId_str='" + coverImgId_str + '\'' +
                    ", sharedUsers=" + sharedUsers +
                    ", shareStatus=" + shareStatus +
                    ", copied=" + copied +
                    '}';
        }
    }
}