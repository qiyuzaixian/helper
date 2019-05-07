package com.github.hps.redis;

public class OrgTreeKey extends BasePrefix {

    public static final int ORG_TREE=3600*24*30;//缓存30天
    /**
     * 防止被外面实例化
     */
    private OrgTreeKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static OrgTreeKey ORG_TREE_List = new OrgTreeKey(ORG_TREE,"ORG_TREE");
}
