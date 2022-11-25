package com.zrq.azi.bean;

import java.util.List;

public class Comment {

    private boolean isMusician;
    private long cnum;
    private long userId;
    private List<?> topComments;
    private boolean moreHot;
    private List<HotCommentsDTO> hotComments;
    private Object commentBanner;
    private int code;
    private List<CommentsDTO> comments;
    private long total;
    private boolean more;

    public boolean isIsMusician() {
        return isMusician;
    }

    public void setIsMusician(boolean isMusician) {
        this.isMusician = isMusician;
    }

    public long getCnum() {
        return cnum;
    }

    public void setCnum(long cnum) {
        this.cnum = cnum;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<?> getTopComments() {
        return topComments;
    }

    public void setTopComments(List<?> topComments) {
        this.topComments = topComments;
    }

    public boolean isMoreHot() {
        return moreHot;
    }

    public void setMoreHot(boolean moreHot) {
        this.moreHot = moreHot;
    }

    public List<HotCommentsDTO> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<HotCommentsDTO> hotComments) {
        this.hotComments = hotComments;
    }

    public Object getCommentBanner() {
        return commentBanner;
    }

    public void setCommentBanner(Object commentBanner) {
        this.commentBanner = commentBanner;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CommentsDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentsDTO> comments) {
        this.comments = comments;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static class HotCommentsDTO {
        private UserDTO user;
        private List<?> beReplied;
        private Object pendantData;
        private Object showFloorComment;
        private long status;
        private long commentId;
        private String content;
        private Object richContent;
        private Object contentResource;
        private long time;
        private String timeStr;
        private boolean needDisplayTime;
        private long likedCount;
        private Object expressionUrl;
        private long commentLocationType;
        private long parentCommentId;
        private Object decoration;
        private Object repliedMark;
        private Object grade;
        private Object userBizLevels;
        private IpLocationDTO ipLocation;
        private boolean liked;

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }

        public List<?> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<?> beReplied) {
            this.beReplied = beReplied;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public long getCommentId() {
            return commentId;
        }

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getRichContent() {
            return richContent;
        }

        public void setRichContent(Object richContent) {
            this.richContent = richContent;
        }

        public Object getContentResource() {
            return contentResource;
        }

        public void setContentResource(Object contentResource) {
            this.contentResource = contentResource;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

        public boolean isNeedDisplayTime() {
            return needDisplayTime;
        }

        public void setNeedDisplayTime(boolean needDisplayTime) {
            this.needDisplayTime = needDisplayTime;
        }

        public long getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(long likedCount) {
            this.likedCount = likedCount;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public long getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(long commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public long getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(long parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public Object getDecoration() {
            return decoration;
        }

        public void setDecoration(Object decoration) {
            this.decoration = decoration;
        }

        public Object getRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(Object repliedMark) {
            this.repliedMark = repliedMark;
        }

        public Object getGrade() {
            return grade;
        }

        public void setGrade(Object grade) {
            this.grade = grade;
        }

        public Object getUserBizLevels() {
            return userBizLevels;
        }

        public void setUserBizLevels(Object userBizLevels) {
            this.userBizLevels = userBizLevels;
        }

        public IpLocationDTO getIpLocation() {
            return ipLocation;
        }

        public void setIpLocation(IpLocationDTO ipLocation) {
            this.ipLocation = ipLocation;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public static class UserDTO {
            private Object locationInfo;
            private Object liveInfo;
            private long anonym;
            private Object commonIdentity;
            private Object avatarDetail;
            private long userType;
            private String avatarUrl;
            private boolean followed;
            private boolean mutual;
            private Object remarkName;
            private VipRightsDTO vipRights;
            private String nickname;
            private long authStatus;
            private Object expertTags;
            private Object experts;
            private long vipType;
            private long userId;

            public Object getLocationInfo() {
                return locationInfo;
            }

            public void setLocationInfo(Object locationInfo) {
                this.locationInfo = locationInfo;
            }

            public Object getLiveInfo() {
                return liveInfo;
            }

            public void setLiveInfo(Object liveInfo) {
                this.liveInfo = liveInfo;
            }

            public long getAnonym() {
                return anonym;
            }

            public void setAnonym(long anonym) {
                this.anonym = anonym;
            }

            public Object getCommonIdentity() {
                return commonIdentity;
            }

            public void setCommonIdentity(Object commonIdentity) {
                this.commonIdentity = commonIdentity;
            }

            public Object getAvatarDetail() {
                return avatarDetail;
            }

            public void setAvatarDetail(Object avatarDetail) {
                this.avatarDetail = avatarDetail;
            }

            public long getUserType() {
                return userType;
            }

            public void setUserType(long userType) {
                this.userType = userType;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

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

            public VipRightsDTO getVipRights() {
                return vipRights;
            }

            public void setVipRights(VipRightsDTO vipRights) {
                this.vipRights = vipRights;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public long getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(long authStatus) {
                this.authStatus = authStatus;
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

            public long getVipType() {
                return vipType;
            }

            public void setVipType(long vipType) {
                this.vipType = vipType;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public static class VipRightsDTO {
                private AssociatorDTO associator;
                private MusicPackageDTO musicPackage;
                private Object redplus;
                private long redVipAnnualCount;
                private long redVipLevel;

                public AssociatorDTO getAssociator() {
                    return associator;
                }

                public void setAssociator(AssociatorDTO associator) {
                    this.associator = associator;
                }

                public MusicPackageDTO getMusicPackage() {
                    return musicPackage;
                }

                public void setMusicPackage(MusicPackageDTO musicPackage) {
                    this.musicPackage = musicPackage;
                }

                public Object getRedplus() {
                    return redplus;
                }

                public void setRedplus(Object redplus) {
                    this.redplus = redplus;
                }

                public long getRedVipAnnualCount() {
                    return redVipAnnualCount;
                }

                public void setRedVipAnnualCount(long redVipAnnualCount) {
                    this.redVipAnnualCount = redVipAnnualCount;
                }

                public long getRedVipLevel() {
                    return redVipLevel;
                }

                public void setRedVipLevel(long redVipLevel) {
                    this.redVipLevel = redVipLevel;
                }

                public static class AssociatorDTO {
                    private long vipCode;
                    private boolean rights;
                    private String iconUrl;

                    public long getVipCode() {
                        return vipCode;
                    }

                    public void setVipCode(long vipCode) {
                        this.vipCode = vipCode;
                    }

                    public boolean isRights() {
                        return rights;
                    }

                    public void setRights(boolean rights) {
                        this.rights = rights;
                    }

                    public String getIconUrl() {
                        return iconUrl;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }
                }

                public static class MusicPackageDTO {
                    private long vipCode;
                    private boolean rights;
                    private String iconUrl;

                    public long getVipCode() {
                        return vipCode;
                    }

                    public void setVipCode(long vipCode) {
                        this.vipCode = vipCode;
                    }

                    public boolean isRights() {
                        return rights;
                    }

                    public void setRights(boolean rights) {
                        this.rights = rights;
                    }

                    public String getIconUrl() {
                        return iconUrl;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }
                }
            }
        }

        public static class IpLocationDTO {
            private Object ip;
            private String location;
            private Object userId;

            public Object getIp() {
                return ip;
            }

            public void setIp(Object ip) {
                this.ip = ip;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }
        }
    }

    public static class CommentsDTO {
        private UserDTO user;
        private List<BeRepliedDTO> beReplied;
        private Object pendantData;
        private Object showFloorComment;
        private long status;
        private long commentId;
        private String content;
        private Object richContent;
        private Object contentResource;
        private long time;
        private String timeStr;
        private boolean needDisplayTime;
        private long likedCount;
        private Object expressionUrl;
        private long commentLocationType;
        private long parentCommentId;
        private DecorationDTO decoration;
        private Object repliedMark;
        private Object grade;
        private Object userBizLevels;
        private IpLocationDTO ipLocation;
        private boolean liked;

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }

        public List<BeRepliedDTO> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<BeRepliedDTO> beReplied) {
            this.beReplied = beReplied;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public long getCommentId() {
            return commentId;
        }

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getRichContent() {
            return richContent;
        }

        public void setRichContent(Object richContent) {
            this.richContent = richContent;
        }

        public Object getContentResource() {
            return contentResource;
        }

        public void setContentResource(Object contentResource) {
            this.contentResource = contentResource;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

        public boolean isNeedDisplayTime() {
            return needDisplayTime;
        }

        public void setNeedDisplayTime(boolean needDisplayTime) {
            this.needDisplayTime = needDisplayTime;
        }

        public long getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(long likedCount) {
            this.likedCount = likedCount;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public long getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(long commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public long getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(long parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public DecorationDTO getDecoration() {
            return decoration;
        }

        public void setDecoration(DecorationDTO decoration) {
            this.decoration = decoration;
        }

        public Object getRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(Object repliedMark) {
            this.repliedMark = repliedMark;
        }

        public Object getGrade() {
            return grade;
        }

        public void setGrade(Object grade) {
            this.grade = grade;
        }

        public Object getUserBizLevels() {
            return userBizLevels;
        }

        public void setUserBizLevels(Object userBizLevels) {
            this.userBizLevels = userBizLevels;
        }

        public IpLocationDTO getIpLocation() {
            return ipLocation;
        }

        public void setIpLocation(IpLocationDTO ipLocation) {
            this.ipLocation = ipLocation;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public static class UserDTO {
            private Object locationInfo;
            private Object liveInfo;
            private long anonym;
            private Object commonIdentity;
            private Object avatarDetail;
            private long userType;
            private String avatarUrl;
            private boolean followed;
            private boolean mutual;
            private Object remarkName;
            private VipRightsDTO vipRights;
            private String nickname;
            private long authStatus;
            private Object expertTags;
            private Object experts;
            private long vipType;
            private long userId;

            public Object getLocationInfo() {
                return locationInfo;
            }

            public void setLocationInfo(Object locationInfo) {
                this.locationInfo = locationInfo;
            }

            public Object getLiveInfo() {
                return liveInfo;
            }

            public void setLiveInfo(Object liveInfo) {
                this.liveInfo = liveInfo;
            }

            public long getAnonym() {
                return anonym;
            }

            public void setAnonym(long anonym) {
                this.anonym = anonym;
            }

            public Object getCommonIdentity() {
                return commonIdentity;
            }

            public void setCommonIdentity(Object commonIdentity) {
                this.commonIdentity = commonIdentity;
            }

            public Object getAvatarDetail() {
                return avatarDetail;
            }

            public void setAvatarDetail(Object avatarDetail) {
                this.avatarDetail = avatarDetail;
            }

            public long getUserType() {
                return userType;
            }

            public void setUserType(long userType) {
                this.userType = userType;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

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

            public VipRightsDTO getVipRights() {
                return vipRights;
            }

            public void setVipRights(VipRightsDTO vipRights) {
                this.vipRights = vipRights;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public long getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(long authStatus) {
                this.authStatus = authStatus;
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

            public long getVipType() {
                return vipType;
            }

            public void setVipType(long vipType) {
                this.vipType = vipType;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public static class VipRightsDTO {
                private AssociatorDTO associator;
                private MusicPackageDTO musicPackage;
                private Object redplus;
                private long redVipAnnualCount;
                private long redVipLevel;

                public AssociatorDTO getAssociator() {
                    return associator;
                }

                public void setAssociator(AssociatorDTO associator) {
                    this.associator = associator;
                }

                public MusicPackageDTO getMusicPackage() {
                    return musicPackage;
                }

                public void setMusicPackage(MusicPackageDTO musicPackage) {
                    this.musicPackage = musicPackage;
                }

                public Object getRedplus() {
                    return redplus;
                }

                public void setRedplus(Object redplus) {
                    this.redplus = redplus;
                }

                public long getRedVipAnnualCount() {
                    return redVipAnnualCount;
                }

                public void setRedVipAnnualCount(long redVipAnnualCount) {
                    this.redVipAnnualCount = redVipAnnualCount;
                }

                public long getRedVipLevel() {
                    return redVipLevel;
                }

                public void setRedVipLevel(long redVipLevel) {
                    this.redVipLevel = redVipLevel;
                }

                public static class AssociatorDTO {
                    private long vipCode;
                    private boolean rights;
                    private String iconUrl;

                    public long getVipCode() {
                        return vipCode;
                    }

                    public void setVipCode(long vipCode) {
                        this.vipCode = vipCode;
                    }

                    public boolean isRights() {
                        return rights;
                    }

                    public void setRights(boolean rights) {
                        this.rights = rights;
                    }

                    public String getIconUrl() {
                        return iconUrl;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }
                }

                public static class MusicPackageDTO {
                    private long vipCode;
                    private boolean rights;
                    private String iconUrl;

                    public long getVipCode() {
                        return vipCode;
                    }

                    public void setVipCode(long vipCode) {
                        this.vipCode = vipCode;
                    }

                    public boolean isRights() {
                        return rights;
                    }

                    public void setRights(boolean rights) {
                        this.rights = rights;
                    }

                    public String getIconUrl() {
                        return iconUrl;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }
                }
            }
        }

        public static class DecorationDTO {
        }

        public static class IpLocationDTO {
            private Object ip;
            private String location;
            private Object userId;

            public Object getIp() {
                return ip;
            }

            public void setIp(Object ip) {
                this.ip = ip;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }
        }

        public static class BeRepliedDTO {
            private UserDTO user;
            private long beRepliedCommentId;
            private String content;
            private Object richContent;
            private long status;
            private Object expressionUrl;
            private IpLocationDTO ipLocation;

            public UserDTO getUser() {
                return user;
            }

            public void setUser(UserDTO user) {
                this.user = user;
            }

            public long getBeRepliedCommentId() {
                return beRepliedCommentId;
            }

            public void setBeRepliedCommentId(long beRepliedCommentId) {
                this.beRepliedCommentId = beRepliedCommentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getRichContent() {
                return richContent;
            }

            public void setRichContent(Object richContent) {
                this.richContent = richContent;
            }

            public long getStatus() {
                return status;
            }

            public void setStatus(long status) {
                this.status = status;
            }

            public Object getExpressionUrl() {
                return expressionUrl;
            }

            public void setExpressionUrl(Object expressionUrl) {
                this.expressionUrl = expressionUrl;
            }

            public IpLocationDTO getIpLocation() {
                return ipLocation;
            }

            public void setIpLocation(IpLocationDTO ipLocation) {
                this.ipLocation = ipLocation;
            }

            public static class UserDTO {
                private Object locationInfo;
                private Object liveInfo;
                private long anonym;
                private Object commonIdentity;
                private Object avatarDetail;
                private long userType;
                private String avatarUrl;
                private boolean followed;
                private boolean mutual;
                private Object remarkName;
                private Object vipRights;
                private String nickname;
                private long authStatus;
                private Object expertTags;
                private Object experts;
                private long vipType;
                private long userId;

                public Object getLocationInfo() {
                    return locationInfo;
                }

                public void setLocationInfo(Object locationInfo) {
                    this.locationInfo = locationInfo;
                }

                public Object getLiveInfo() {
                    return liveInfo;
                }

                public void setLiveInfo(Object liveInfo) {
                    this.liveInfo = liveInfo;
                }

                public long getAnonym() {
                    return anonym;
                }

                public void setAnonym(long anonym) {
                    this.anonym = anonym;
                }

                public Object getCommonIdentity() {
                    return commonIdentity;
                }

                public void setCommonIdentity(Object commonIdentity) {
                    this.commonIdentity = commonIdentity;
                }

                public Object getAvatarDetail() {
                    return avatarDetail;
                }

                public void setAvatarDetail(Object avatarDetail) {
                    this.avatarDetail = avatarDetail;
                }

                public long getUserType() {
                    return userType;
                }

                public void setUserType(long userType) {
                    this.userType = userType;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

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

                public Object getVipRights() {
                    return vipRights;
                }

                public void setVipRights(Object vipRights) {
                    this.vipRights = vipRights;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public long getAuthStatus() {
                    return authStatus;
                }

                public void setAuthStatus(long authStatus) {
                    this.authStatus = authStatus;
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

                public long getVipType() {
                    return vipType;
                }

                public void setVipType(long vipType) {
                    this.vipType = vipType;
                }

                public long getUserId() {
                    return userId;
                }

                public void setUserId(long userId) {
                    this.userId = userId;
                }
            }

            public static class IpLocationDTO {
                private Object ip;
                private String location;
                private Object userId;

                public Object getIp() {
                    return ip;
                }

                public void setIp(Object ip) {
                    this.ip = ip;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public Object getUserId() {
                    return userId;
                }

                public void setUserId(Object userId) {
                    this.userId = userId;
                }
            }
        }
    }
}
