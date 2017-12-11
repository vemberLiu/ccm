package com.wondertek.mam.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.wondertek.mam.model.Asset;
import com.wondertek.mam.model.BaseAttrEnum;
import com.wondertek.mam.model.Epg;
import com.wondertek.mobilevideo.core.base.GenericManager;

/**
 * EPG生产
 * @author Wang Cancan
 */
public interface EpgProduceService extends GenericManager<Epg, Long> {
	public void saveOrUpdateE(Epg e);
	
	public Epg saveE(Epg e);
	
	public void saveOrUpdateAllE(List<Epg> eList);
	
	public void removeE(Long id);
	
	/**
	 * 删除所有的节目
	 * @param list
	 */
	public void deleteAllEpg(List<Epg> list);
	
	/**
	 * 根据查询条件,查频道,无分页
	 * @param map
	 * @return
	 */
	public List<Asset> getChannelByType(Map<String, Object> map);
	
	/**
	 * 根据查询条件,查频道,有分页
	 * @param map
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Asset> getChannelByTypeAndPage(Map<String, Object> map, int page, int limit);
	
	/**
	 * 根据媒资id查询所属的图片,作为台标
	 * @param assetId
	 * @return
	 */
	public String getImgByAssetId(Long assetId);
	
	/**
	 * epg节目的总数
	 * @param map
	 * @return
	 */
	public long getEpgBillCount(Map<String, Object> map);
	
	/**
	 * 查询所有的节目
	 * @param map
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Epg> queryEpgList(Map<String, Object> map, int start, int limit);
	
	/**
	 * 根据cpId查询所有频道时,如果配置了miguCpid参数,则查出所有的频道
	 * @return
	 */
	public List<Asset> getAllChannel(Map<String, Object> map);
	
	/**
	 * 分页:根据cpId查询所有频道时,如果配置了miguCpid参数,则查出所有的频道
	 * @return
	 */
	public List<Asset> getAllChannelAndPage(Map<String, Object> map, int start, int limit);
	
	/**
	 * 根据cpId查询所有频道
	 * @return
	 */
	public List<Asset> getChannelByCpId(Map<String, Object> map);
	
	/**
	 * 分页:根据cpId查询所有频道
	 * @return
	 */
	public List<Asset> getChannelByCpIdAndPage(Map<String, Object> map, int start, int limit);
	
	/**
	 * Epg管理界面根据频道的类型,查询所有的频道分类
	 * @param attrId
	 * @return
	 */
	public List<BaseAttrEnum> getClassifyByAttrId(Long attrId);
	
	/**
	 * Epg生产中的查询节目单(删除了Epg管理后的查询方法)
	 * @param map
	 * @return
	 */
	public List<Epg> getEpgBill(Map<String, Object> map);
	
	/**
	 * Epg生产中,界面初始化时,根据登陆人的组织Id,加载同一组织所操作的频道
	 * @param orgId
	 * @return
	 */
	public List<Asset> getChannelByOrg(Long orgId);
	
	/**
	 * 根据组织id查询带有分页的频道
	 * @param orgId
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Asset> getChannelByOrgAndPage(Long orgId, int start, int limit);
	
	/**
	 * 获取当前频道最后一条节目的开始时间
	 * @param channelId
	 * @return
	 */
	public String getEpgLastTime(Long channelId);
	
	/**
	 * 获取当前频道的节目中,开始时间大于指定时间的所有节目
	 * @param beginTime
	 * @return
	 */
	public List<Epg> getEpgLargeTime(String beginTime);
	
	/**
	 * 发布EPG的节目
	 * @param assetId
	 * @param needToSync 是否需要同步节目单(当手动点发布按钮时,立刻同步节目单到POMS)
	 */
	public void publishEpg(Long assetId, boolean needToSync);

	/**
	 * 根据频道ID获取模拟频道的节目列表
	 */
	public List<Map<String, Object>> getSelfChannelProgram(Map<String,Object> paramsMap);
	
	/**
	 * 定时任务发布-->需要进行发布的频道
	 * @param map
	 * @return
	 */
	public List<Object> channelNeedToPublish(Map<String, Object> map);
	
	/**
	 * 批量导入节目单
	 * @param file 待导入的txt格式的节目单
	 * @param channelId 节目单所属的频道ID
	 * @param userId 
	 * @param userName
	 * @return 为空,导入成功;不为空,返回失败理由
	 */
	public String importFile(File file, Long channelId, Long userId, String userName);
	/**
	 * 将要发送的节目单的xml读取出来并转化为String
	 * @return
	 */
	public String transXmlToString();
	
	/**
	 * 发送节目单给网云系统
	 */
	public String postEpgXml(String url, NameValuePair[] values,String xml,String charSet);
	
	
}
