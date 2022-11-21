package com.zrq.azi.bean;

import androidx.annotation.Keep;

@Keep
public class UserInfo {

    private long code;
    private AccountDTO account;
    private ProfileDTO profile;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public static class AccountDTO {
        private long id;
        private String userName;
        private long type;
        private long status;
        private long whitelistAuthority;
        private long createTime;
        private long tokenVersion;
        private long ban;
        private long baoyueVersion;
        private long donateVersion;
        private long vipType;
        private boolean anonimousUser;
        private boolean paidFee;

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

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        public boolean isPaidFee() {
            return paidFee;
        }

        public void setPaidFee(boolean paidFee) {
            this.paidFee = paidFee;
        }
    }

    public static class ProfileDTO {
        private long userId;
        private long userType;
        private String nickname;
        private long avatarImgId;
        private String avatarUrl;
        private long backgroundImgId;
        private String backgroundUrl;
        private String signature;
        private long createTime;
        private String userName;
        private long accountType;
        private String shortUserName;
        private long birthday;
        private long authority;
        private long gender;
        private long accountStatus;
        private long province;
        private long city;
        private long authStatus;
        private Object description;
        private Object detailDescription;
        private boolean defaultAvatar;
        private Object expertTags;
        private Object experts;
        private long djStatus;
        private long locationStatus;
        private long vipType;
        private boolean followed;
        private boolean mutual;
        private boolean authenticated;
        private long lastLoglongime;
        private String lastLoginIP;
        private Object remarkName;
        private long viptypeVersion;
        private long authenticationTypes;
        private Object avatarDetail;
        private boolean anchor;

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

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public long getAccountType() {
            return accountType;
        }

        public void setAccountType(long accountType) {
            this.accountType = accountType;
        }

        public String getShortUserName() {
            return shortUserName;
        }

        public void setShortUserName(String shortUserName) {
            this.shortUserName = shortUserName;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getAuthority() {
            return authority;
        }

        public void setAuthority(long authority) {
            this.authority = authority;
        }

        public long getGender() {
            return gender;
        }

        public void setGender(long gender) {
            this.gender = gender;
        }

        public long getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(long accountStatus) {
            this.accountStatus = accountStatus;
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

        public long getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(long authStatus) {
            this.authStatus = authStatus;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(Object detailDescription) {
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

        public long getLocationStatus() {
            return locationStatus;
        }

        public void setLocationStatus(long locationStatus) {
            this.locationStatus = locationStatus;
        }

        public long getVipType() {
            return vipType;
        }

        public void setVipType(long vipType) {
            this.vipType = vipType;
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

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public long getLastLoglongime() {
            return lastLoglongime;
        }

        public void setLastLoglongime(long lastLoglongime) {
            this.lastLoglongime = lastLoglongime;
        }

        public String getLastLoginIP() {
            return lastLoginIP;
        }

        public void setLastLoginIP(String lastLoginIP) {
            this.lastLoginIP = lastLoginIP;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public long getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(long viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
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
    }
}
