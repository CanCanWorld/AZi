package com.zrq.azi.bean;

import androidx.annotation.Keep;

import java.util.List;

@Keep
public class LoginInfo {

    private long loglongype;
    private int code;
    private AccountDTO account;
    private String token;
    private ProfileDTO profile;
    private List<BindingsDTO> bindings;
    private String cookie;

    public long getLoglongype() {
        return loglongype;
    }

    public void setLoglongype(long loglongype) {
        this.loglongype = loglongype;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public List<BindingsDTO> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsDTO> bindings) {
        this.bindings = bindings;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public static class AccountDTO {
        private long id;
        private String userName;
        private long type;
        private long status;
        private long whitelistAuthority;
        private long createTime;
        private String salt;
        private long tokenVersion;
        private long ban;
        private long baoyueVersion;
        private long donateVersion;
        private long vipType;
        private long viptypeVersion;
        private boolean anonimousUser;
        private boolean uninitialized;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public long getType() {
            return type;
        }

        public void setType(long type) {
            this.type = type;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public long getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(long whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public long getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(long tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public long getBan() {
            return ban;
        }

        public void setBan(long ban) {
            this.ban = ban;
        }

        public long getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(long baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public long getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(long donateVersion) {
            this.donateVersion = donateVersion;
        }

        public long getVipType() {
            return vipType;
        }

        public void setVipType(long vipType) {
            this.vipType = vipType;
        }

        public long getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(long viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        public boolean isUninitialized() {
            return uninitialized;
        }

        public void setUninitialized(boolean uninitialized) {
            this.uninitialized = uninitialized;
        }
    }

    public static class ProfileDTO {
        private boolean followed;
        private String backgroundUrl;
        private long userId;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private long userType;
        private String avatarUrl;
        private long vipType;
        private long authStatus;
        private long djStatus;
        private String detailDescription;
        private ExpertsDTO experts;
        private Object expertTags;
        private long accountStatus;
        private String nickname;
        private long birthday;
        private long gender;
        private long province;
        private long city;
        private long avatarImgId;
        private long backgroundImgId;
        private boolean defaultAvatar;
        private Object remarkName;
        private boolean mutual;
        private String description;
        private String signature;
        private long authority;
        private String avatarImgId_str;
        private long followeds;
        private long follows;
        private long eventCount;
        private Object avatarDetail;
        private long playlistCount;
        private long playlistBeSubscribedCount;

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

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
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

        public long getVipType() {
            return vipType;
        }

        public void setVipType(long vipType) {
            this.vipType = vipType;
        }

        public long getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(long authStatus) {
            this.authStatus = authStatus;
        }

        public long getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(long djStatus) {
            this.djStatus = djStatus;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public ExpertsDTO getExperts() {
            return experts;
        }

        public void setExperts(ExpertsDTO experts) {
            this.experts = experts;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public long getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(long accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getGender() {
            return gender;
        }

        public void setGender(long gender) {
            this.gender = gender;
        }

        public long getProvince() {
            return province;
        }

        public void setProvince(long province) {
            this.province = province;
        }

        public long getCity() {
            return city;
        }

        public void setCity(long city) {
            this.city = city;
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

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
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

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public long getFolloweds() {
            return followeds;
        }

        public void setFolloweds(long followeds) {
            this.followeds = followeds;
        }

        public long getFollows() {
            return follows;
        }

        public void setFollows(long follows) {
            this.follows = follows;
        }

        public long getEventCount() {
            return eventCount;
        }

        public void setEventCount(long eventCount) {
            this.eventCount = eventCount;
        }

        public Object getAvatarDetail() {
            return avatarDetail;
        }

        public void setAvatarDetail(Object avatarDetail) {
            this.avatarDetail = avatarDetail;
        }

        public long getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(long playlistCount) {
            this.playlistCount = playlistCount;
        }

        public long getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(long playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public static class ExpertsDTO {
        }
    }

    public static class BindingsDTO {
        private long userId;
        private String url;
        private boolean expired;
        private long bindingTime;
        private long refreshTime;
        private String tokenJsonStr;
        private long expiresIn;
        private long id;
        private long type;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public long getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(long refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }

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
    }
}
