package com.zlr.vhr.util;

/**
 *- 用户中心和账户中心，所有表索引维护
 *-drop打头的为删除索引，另一个为创建索引。
 *
 *- warn: 切记不要format code。
 */
public class JFIndexUtil {
	
	public static void main(String args[]) {

		// i为分库后缀，取值范围是[0,3]
		int i=3;
		if (args!=null && args.length>0) {
			i= Integer.parseInt(args[0]);
		}
		
//		jf_acct_partner();
//		drop_jf_acct_partner();

		jf_acct_personal(i);
//		drop_jf_acct_personal(i);
		
//		jf_base();
//		drop_jf_base();
		
//		jf_user(i);
//		drop_jf_user(i);
	}
	
	public static void jf_user(int i) {
		
			for (int j = 0; j < 40; j++) {
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_safe_mod_pwd_rec_"+j+"  ADD INDEX idx_jf_user_"+i+"_user_safe_mod_pwd_rec_"+j+"_user_id(USER_ID) USING BTREE,"
						+ " ADD INDEX idx_jf_user_"+i+"_user_safe_mod_pwd_rec_"+j+"_pwd_mod_time(PWD_MOD_TIME) USING BTREE;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_addr_"+j+"  ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_user_id(USER_ID) USING BTREE,"
						+ " ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_status(STATUS) USING BTREE,"
						+ "ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_province_code(PROVINCE_CODE) USING BTREE,"
						+ "ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_city_code(CITY_CODE) USING BTREE,"
						+ "ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_default_flag(DEFAULT_FLAG) USING BTREE,"
						+ "ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_create_time(CREATE_TIME) USING BTREE,"
						+ "ADD INDEX idx_jf_user_"+i+"_user_addr_"+j+"_cust_name(CUST_NAME) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_collect_ware_info_"+j+"  ADD INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_userId(USER_ID) USING BTREE,"
						+ " ADD INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_ware_id(WARE_ID) USING BTREE, "
						+ "ADD INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_create_time(CREATE_TIME) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_inter_auth_"+j+"  ADD INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_userId(USER_ID) USING BTREE,"
						+ " ADD INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_inter_type(INTER_TYPE) USING BTREE, "
						+ "ADD INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_inter_id(INTER_ID) USING BTREE ;");
			}
		
		
	}
	
	public static void drop_jf_user(int i) {
		
			for (int j = 0; j < 40; j++) {
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_safe_mod_pwd_rec_"+j+"  DROP INDEX idx_jf_user_"+i+"_user_safe_mod_pwd_rec_"+j+"_user_id,"
						+ " DROP INDEX idx_jf_user_"+i+"_user_safe_mod_pwd_rec_"+j+"_pwd_mod_time;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_addr_"+j+"  DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_user_id,"
						+ " DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_status,"
						+ "DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_province_code,"
						+ "DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_city_code,"
						+ "DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_default_flag,"
						+ "DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_create_time,"
						+ "DROP INDEX idx_jf_user_"+i+"_user_addr_"+j+"_cust_name;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_collect_ware_info_"+j+"  DROP INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_userId,"
						+ " DROP INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_ware_id, "
						+ "DROP INDEX idx_jf_user_"+i+"_user_collect_ware_info_"+j+"_create_time;");
				
				System.out.println("ALTER TABLE jf_user_"+i+".user_inter_auth_"+j+"  DROP INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_userId,"
						+ " DROP INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_inter_type, "
						+ "DROP INDEX idx_jf_user_"+i+"_user_inter_auth_"+j+"_inter_id;");
		}
		
		
	}
	
	public static void jf_acct_partner() {
		
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_main ADD INDEX idx_jf_acct_partner_acct_partner_main_partner_id(PARTNER_ID) USING BTREE;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_deposit_record ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_acct_name(ACCT_NAME) USING BTREE,"
						+ " ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_partner_code(PARTNER_CODE) USING BTREE,"
						+ " ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_status(STATUS) USING BTREE,"
						+ " ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_create_time(CREATE_TIME) USING BTREE,"
						+ " ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_deposit_apply_no(DEPOSIT_APPLY_NO) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_firstcheckoperid(FIRST_CHECK_OPER_ID) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_deposit_record_recheckoperid(RE_CHECK_OPER_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_info ADD INDEX idx_jf_acct_partner_acct_partner_info_partner_code(PARTNER_CODE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_info_partner_name(PARTNER_NAME) USING BTREE, "
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_info_status(STATUS) USING BTREE;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_sub ADD INDEX idx_jf_acct_partner_acct_partner_sub_partner_id(PARTNER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_sub_create_time(CREATE_TIME) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_change_record ADD INDEX idx_jf_acct_partner_acct_partner_change_record_change_type(CHANGE_TYPE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_acct_detail_id(ACCT_DETAIL_ID) USING BTREE, "
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_outer_tran_id(OUTER_TRAN_ID) USING BTREE, "
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_change_time(CHANGE_TIME) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_outer_tran_type(OUTER_TRAN_TYPE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_change_amount(CHANGE_AMOUNT) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_change_record_partner_id(PARTNER_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_sub_detail ADD INDEX idx_jf_acct_partner_acct_partner_sub_detail_partner_id(PARTNER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_sub_detail_create_time(CREATE_TIME) USING BTREE ;");
				
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_dist_batch ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_status(DIST_STATUS) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_time(DIST_TIME) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_code(PARTNER_CODE) USING BTREE, "
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_name(PARTNER_NAME) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_batch_no(DIST_BATCH_NO) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_id(PARTNER_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_partner_dist_record ADD INDEX idx_jf_acct_partner_acct_partner_dist_record_partner_id(PARTNER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_batch_no(DIST_BATCH_NO) USING BTREE, "
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_status(DIST_STATUS) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_user_mobile(DIST_USER_MOBILE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_partner_dist_record_update_time(UPDATE_TIME) USING BTREE ;");
				
				
				System.out.println("ALTER TABLE jf_acct_partner.acct_com_task ADD INDEX idx_jf_acct_partner_acct_com_task_state(STATE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_partner_acct_com_task_task_type(TASK_TYPE) USING BTREE ;");
		
		
	}
	public static void drop_jf_acct_partner() {
		
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_main DROP INDEX idx_jf_acct_partner_acct_partner_main_partner_id;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_deposit_record DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_acct_name,"
				+ " DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_partner_code,"
				+ " DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_status,"
				+ " DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_create_time,"
				+ " DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_deposit_apply_no,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_firstcheckoperid,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_deposit_record_recheckoperid;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_info DROP INDEX idx_jf_acct_partner_acct_partner_info_partner_code,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_info_partner_name, "
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_info_status;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_sub DROP INDEX idx_jf_acct_partner_acct_partner_sub_partner_id,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_sub_create_time;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_change_record DROP INDEX idx_jf_acct_partner_acct_partner_change_record_change_type,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_acct_detail_id, "
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_outer_tran_id, "
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_change_time,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_outer_tran_type,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_change_amount,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_change_record_partner_id;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_sub_detail DROP INDEX idx_jf_acct_partner_acct_partner_sub_detail_partner_id,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_sub_detail_create_time;");
		
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_dist_batch DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_status,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_time,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_code, "
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_name,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_dist_batch_no,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_batch_partner_id;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_partner_dist_record DROP INDEX idx_jf_acct_partner_acct_partner_dist_record_partner_id,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_batch_no, "
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_status,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_record_dist_user_mobile,"
				+ "DROP INDEX idx_jf_acct_partner_acct_partner_dist_record_update_time;");
		
		System.out.println("ALTER TABLE jf_acct_partner.acct_com_task DROP INDEX idx_jf_acct_partner_acct_com_task_state,"
				+ "DROP INDEX idx_jf_acct_partner_acct_com_task_task_type;");
		
	}
	
	
public static void jf_acct_personal(int i) {
		
			for (int j = 0; j < 40; j++) {
//				
				System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_pay_pwd_"+j+"  ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_pay_pwd_"+j+"_user_id(USER_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_main_"+j+"  ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_main_"+j+"_user_id(USER_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_sub_"+j+"  ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_user_id(USER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_sub_acct_source(SUB_ACCT_SOURCE) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_acct_id(ACCT_ID) USING BTREE ;");
				
				System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_sub_detail_"+j+"  ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_detail_"+j+"_user_id(USER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_acct_id(ACCT_ID) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_sub_acct_id(SUB_ACCT_ID) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_jf_amount(JF_AMOUNT) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_status(STATUS) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_start_date(START_DATE) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_end_date(END_DATE) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_invhandflag(INVALID_HANDLE_FLAG) USING BTREE;");
				
				System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_change_record_"+j+""
						+ "  ADD INDEX idx_jf_acct_personal_"+i+"_acct_personal_change_record_"+j+"_user_id(USER_ID) USING BTREE,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertranid(OUTER_TRAN_ID) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertransubid(OUTER_TRAN_SUB_ID) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertrantype(OUTER_TRAN_TYPE) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_change_source(CHANGE_SOURCE) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_change_type(CHANGE_TYPE) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_create_time(CREATE_TIME) USING BTREE ,"
						+ "ADD INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_acctdetailid(ACCT_DETAIL_ID) USING BTREE;");
			}
			
	}

public static void drop_jf_acct_personal(int i) {
	
		for (int j = 0; j < 40; j++) {
			
			System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_pay_pwd_"+j+"  DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_pay_pwd_"+j+"_user_id ;");
			
			System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_main_"+j+"  DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_main_"+j+"_user_id ;");
			
			System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_sub_"+j+"  DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_user_id,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_sub_acct_source ,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_"+j+"_acct_id ;");
			
			System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_sub_detail_"+j+"  DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_sub_detail_"+j+"_user_id,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_acct_id,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_sub_acct_id,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_jf_amount,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_status,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_start_date,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_end_date,"
					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalsubdetail_"+j+"_invhandflag;");
			
//			System.out.println("ALTER TABLE jf_acct_personal_"+i+".acct_personal_change_record_"+j+"  DROP INDEX idx_jf_acct_personal_"+i+"_acct_personal_change_record_"+j+"_user_id,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertranid,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertransubid,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_outertrantype,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_change_source,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_change_type,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_create_time,"
//					+ "DROP INDEX idx_jf_acct_personal_"+i+"_acctpersonalchanrec_"+j+"_acctdetailid;");
		}
	
}


	public static void jf_base() {
		
		
		System.out.println("ALTER TABLE jf_base.sys_area ADD INDEX idx_jf_base_sys_area_parent_code(PARENT_CODE) USING BTREE,"
				+ " ADD INDEX idx_jf_base_sys_area_used_flag(USED_FLAG) USING BTREE,"
				+ "ADD INDEX idx_jf_base_sys_area_dis_order(DIS_ORDER) USING BTREE ;");
		
		System.out.println("ALTER TABLE jf_base.tx_comp_task ADD INDEX idx_jf_base_tx_comp_task_task_type(TASK_TYPE) USING BTREE,"
				+ " ADD INDEX idx_jf_base_tx_comp_task_src_queue(SRC_QUEUE) USING BTREE,"
				+ "ADD INDEX idx_jf_base_tx_comp_task_busi_type(BUSI_TYPE) USING BTREE ,"
				+ "ADD INDEX idx_jf_base_tx_comp_task_user_id(USER_ID) USING BTREE ,"
				+ "ADD INDEX idx_jf_base_tx_comp_task_status(STATUS) USING BTREE ,"
				+ "ADD INDEX idx_jf_base_tx_comp_task_create_time(CREATE_TIME) USING BTREE ;");
		
	}
	public static void drop_jf_base() {
		
		
		System.out.println("ALTER TABLE jf_base.sys_area DROP INDEX idx_jf_base_sys_area_parent_code,"
				+ " DROP INDEX idx_jf_base_sys_area_used_flag,"
				+ "DROP INDEX idx_jf_base_sys_area_dis_order;");
		
		
		System.out.println("ALTER TABLE jf_base.tx_comp_task DROP INDEX idx_jf_base_tx_comp_task_task_type,"
				+ " DROP INDEX idx_jf_base_tx_comp_task_src_queue,"
				+ "DROP INDEX idx_jf_base_tx_comp_task_busi_type,"
				+ "DROP INDEX idx_jf_base_tx_comp_task_user_id,"
				+ "DROP INDEX idx_jf_base_tx_comp_task_status,"
				+ "DROP INDEX idx_jf_base_tx_comp_task_create_time;");
		
	}

	
}
