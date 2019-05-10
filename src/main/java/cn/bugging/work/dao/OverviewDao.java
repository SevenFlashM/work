package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface OverviewDao {

	/**
	 * 
	 * @return 我新建的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE creator=#{creator} AND status_id=1")
	int getMyCreateNum(String creator);

	/**
	 * 
	 * @return 指派给我的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto}")
	int getBelongtoMeNum(String belongto);

	/**
	 * 
	 * @return 待我解决的问题数目(所属人为自己，状态!=已拒绝和已验收
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	int getMyHandlingNum(String belongto);

	/**
	 * 
	 * @return 我跟踪的问题数目(创建人或者所属人为自己的问题，并且问题状态！=已拒绝和已验收)
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE creator=#{creator} OR belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	int getMyTraceNum(String creator,String belongto);
	
	/**
	 * 
	 * @return 我解决的问题数目(所属人为自己的问题，并且问题状态=已解决)
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=3")
	int getMySolvedNum(String belongto);

	/**
	 * 
	 * @return 我拒绝问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=4")
	int getAMyRefusedNum();

	/**
	 * 
	 * @return 我被验收问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=5")
	int getMyCheckedNum();

	/**
	 * 
	 * @return 我延期问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=6")
	int getMyDelayedNum();
	
	
	/**
	 * 
	 * @return 所有未关闭的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id!=4 AND status_id!=5")
	int getAllUnclosedNum();

	/**
	 * @return 所有新建问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=1")
	int getAllNewCreateNum();

	/**
	 * 
	 * @return 所有处理中问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=2")
	int getAllHandlingNum();

	/**
	 * 
	 * @return 所有已解决问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=3")
	int getAllSolvedNum();

	/**
	 * 
	 * @return 所有已拒绝问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=4")
	int getAllRefusedNum();

	/**
	 * 
	 * @return 所有已验收问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=5")
	int getAllCheckedNum();

	/**
	 * 
	 * @return 所有延期问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=6")
	int getAllDelayedNum();

}
