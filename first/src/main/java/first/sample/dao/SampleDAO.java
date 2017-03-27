package first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

//단순히 DB에 접속해서 필요한 데이터를 조회하는 역할
@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO
{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("sample.insertBoard", map);
	}
	
	////필요한 쿼리 각각 호출
	public void updateHitCnt(Map<String, Object> map) throws Exception{
	    update("sample.updateHitCnt", map);
	}
	 
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
	    return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
	}

	public void updateBoard(Map<String, Object> map) {
		update("sample.updateBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) {
		update("sample.deleteBoard", map);
	}
}
