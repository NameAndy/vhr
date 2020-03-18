package com.zlr.vhr.common.constants;

/**
 * SDK常量 Date: 2017年2月22日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author
 */
public final class SystemConstant {

    private SystemConstant() {

    }

    /**
     * PaaS配置中心配置文件
     */
    public static final String PAAS_CONFIG_FILE = "paas/paas-conf.properties";

    /**
     * 环境变量zookeeper的key
     */
    public static final String ZK_PROP_KEY = "dubbo.registry.address";
    /**
     * 环境变量zookeeper的user
     */
    public static final String ZK_USER_KEY = "zk.user.name";
    /**
     * 环境变量zookeeper的userPassword
     */
    public static final String ZK_PASSWORD_KEY = "zk.user.password";

    /**
     * PaaS使用模式
     */
    public static final class PAASMODE {
        private PAASMODE() {
        };

        public static final String PAAS_SRV_MODE = "srv";// 服务模式
        public static final String PAAS_SDK_MODE = "sdk";// sdk模式
    }

    /**
     * 配置某种场景下用哪个缓存服务ID
     * {"com.ai.channel.xxx.xxx":"MCS001","com.ai.channel.xxx.yyy":"MCS002","com.ai.channel.xxx.zzz":"MCS003"}
     */
    public static final String PAAS_CACHENS_MCS_MAPPED_PATH = "/com/ai/jf/paas-cachens-mcs-mapped";

    /**
     * sdk模式下，mcs对应的真实redis主机信息<br/>
     * <p/>
     * 示例数据： { "MCS001": { "mcs.mode":"single|master|sentinel|cluster|codis"
     * "mcs.host":"127.0.0.1:6379", "mcs.maxtotal":"200", "mcs.maxIdle":"10",
     * "mcs.minIdle":"5", "mcs.testOnBorrow":"true", "mcs.password":"" }, "MCS002":
     * { "mcs.mode":"single|master|sentinel|cluster|codis"
     * "mcs.host":"192.168.0.21:6379;192.168.0.22:6379;192.168.0.23:6379",
     * "mcs.maxtotal":"200", "mcs.maxIdle":"10", "mcs.minIdle":"5",
     * "mcs.testOnBorrow":"true", "mcs.password":"" } }
     */
    public static final String SDK_MODE_PAAS_MCS_REDIS_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-mcs-redis-mapped";

    /**
     * 配置某种场景下用哪个消息服务ID
     * {"baasSmcCheckTopic":"MDS001","baasAmcTopic":"MDS002","baasOmcTopic":"MDS003"}
     */
    public static final String PAAS_MDSNS_MDS_MAPPED_PATH = "/com/ai/jf/paas-mdsns-mds-mapped";

    /**
     * sdk模式下，mds sender对应的真实kafka信息 { "MDS001": {
     * "bootstrap.servers":"10.12.2.144:19092,10.12.2.145:19092,10.12.2.146:19092",
     * "topic":"DOUBO_TEST","maxProducer":10 } }
     */
    public static final String SDK_MODE_PAAS_MDS_SENDER_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-mds-sender-mapped";
    /**
     * sdk模式下，mds consumer对应的真实kafka信息 { "MDS001": {
     * "bootstrap.servers":"10.12.2.144:19092,10.12.2.145:19092,10.12.2.146:19092",
     * "topic":"DOUBO_TEST", "group.id":"jf_kafka_demo","partitions":2 } }
     */
    public static final String SDK_MODE_PAAS_MDS_CONSUMER_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-mds-consumer-mapped";

    // 配置消息服务ID与实际kakfa topic名称的映射关系
    // {"MDS001":"BCA976731EF24B899B143755A3AF5794_MDS001_1743120261","MDS002":"BCA976731EF24B899B143755A3AF5794_MDS001_1743120261"}
    public static final String PAAS_MDS_TOPIC_MAPPED_PATH = "/com/ai/jf/paas-mds-topic-mapped";

    /**
     * 配置某种场景下用哪个文档存储服务ID
     * {"com.ai.channel.xxx.xxx":"DSS001","com.ai.channel.xxx.yyy":"DSS002","com.ai.channel.xxx.zzz":"DSS003"}
     */
    public static final String PAAS_DSSNS_DSS_MAPPED_PATH = "/com/ai/jf/paas-dssns-dss-mapped";

    //
    //
    /**
     * sdk模式下，paas服务对应的真实mongodb信息 { "DSS001": {
     * "mongoServer":"10.1.xxx.xxx:37017;10.1.xxx.xxx:37017", "database":"image",
     * "userName":"sa", "password":"sa", "bucket":"mygridfs01" }, "DSS002": {
     * "mongoServer":"10.1.xxx.xxx:37017;10.1.xxx.xxx:37017", "database":"image",
     * "userName":"sa", "password":"sa", "bucket":"mygridfs01" } }
     */
    public static final String SDK_MODE_PAAS_DSS_MONGO_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-dss-mongodb-mapped";

    /**
     * 配置某种场景下用哪个图片服务ID
     * {"com.ai.channel.xxx.xxx":"IDPS001","com.ai.channel.xxx.yyy":"IDPS002","com.ai.channel.xxx.zzz":"IDPS003"}
     */
    public static final String PAAS_IDPSNS_IDPS_MAPPED_PATH = "/com/ai/jf/paas-idpsns-idps-mapped";

    /**
     * sdk模式下，paas服务对应的真实elasticsearch信息 { "IDPS001": {
     * "interUrl":"http://10.1.245.8:18030/iPaas-IDPS",
     * "intraUrl":"http://10.1.245.8:18030/iPaas-IDPS" }, "IDPS002": {
     * "interUrl":"http://www.xxx.com/iPaas-IDPS/",
     * "intraUrl":"http://10.1.245.226:18000/iPaas-IDPS/" } }
     */
    public static final String SDK_MODE_PAAS_IDPS_GM_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-idps-gm-mapped";

    /**
     * 配置某种场景下用哪个搜索服务ID
     * {"com.ai.channel.xxx.xxx":"SES001","com.ai.channel.xxx.yyy":"SES002","com.ai.channel.xxx.zzz":"SES003"}
     */
    public static final String PAAS_SESNS_SES_MAPPED_PATH = "/com/ai/jf/paas-sesns-ses-mapped";

    /**
     * sdk模式下，paas服务对应的真实elasticsearch信息 { "SES001": {
     * "eshosts":"127.0.0.1:9300,127.0.0.1:9300", "indexname":"user-detail-index",
     * "mappingid":"userid", "mapping": { "userInfo" : { "properties" : { "userId" :
     * {"type" : "string", "store" : "yes","index": "not_analyzed"}, "name" :
     * {"type" : "string", "store" : "yes","analyzer":"ik_max_word"}, "age" :
     * {"type" : "integer"}, "created" : {"type" : "date", "format" :
     * "strict_date_optional_time||epoch_millis"} } } }, "shards":"2",
     * "replicas":"1" }, "SES002": { "eshosts":"127.0.0.1:9300,127.0.0.1:9300",
     * "indexname":"order-detail-index", "mappingid":"orderid", "mapping": {
     * "userInfo" : { "properties" : { "userId" : {"type" : "string", "store" :
     * "yes","index": "not_analyzed"}, "name" : {"type" : "string", "store" :
     * "yes","analyzer":"ik_max_word"}, "age" : {"type" : "integer"}, "created" :
     * {"type" : "date", "format" : "strict_date_optional_time||epoch_millis"} } }
     * }, "shards":"2", "replicas":"1" } }
     */
    public static final String SDK_MODE_PAAS_SES_ELASTICSEARCH_MAPPED_PATH = "/com/ai/jf/sdkmode-paas-ses-elasticsearch-mapped";

    /**
     * 技术服务与密码的映射关系 {"MCS001":"password","DSS001":"password","MDS001":"password"}
     */
    public static final String PAAS_SERVICE_PWD_MAPPED_PATH = "/com/ai/jf/paas-service-pwd-mapped";

    /**
     * db-conf的配置信息 /com/ai/jf/db-conf { "opt-uac-db": { "encrypt":"true",
     * "driverClassName":"com.mysql.jdbc.Driver",
     * "jdbcUrl":"jdbc:mysql://10.1.228.222:39306/devibssgndb1?useUnicode=true&characterEncoding=UTF-8",
     * "username":"devibssgnusr1", "password":"devibssgnusr1", "autoCommit":"true",
     * "connectionTimeout":"30000", "idleTimeout":"600000", "maxLifetime":"1800000",
     * "maximumPoolSize":"10" }, "opt-sys-db": {
     * "driverClassName":"com.mysql.jdbc.Driver", "jdbcUrl"
     * :"jdbc:mysql://10.1.228.222:39306/devibsscmdb1?useUnicode=true&characterEncoding=UTF-8",
     * "username":"devibsscmusr1", "password":"devibsscmusr1", "autoCommit":"true",
     * "connectionTimeout":"30000", "idleTimeout":"600000", "maxLifetime":"1800000",
     * "maximumPoolSize":"10" } }
     */
    public static final String DB_CONF_PATH = "/com/ai/jf/db-conf";

}
