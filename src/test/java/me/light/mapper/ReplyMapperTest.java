package me.light.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.Criteria;
import me.light.model.ReplyVO;

public class ReplyMapperTest extends AppTest {

	@Autowired
	ReplyMapper mapper;

	@Test
	@Ignore
	public void getList() {
		List<ReplyVO> list = mapper.getListAll();
		System.out.println(list);
		assertNotNull(list);
		assertEquals(2, list.size());
	}

	@Test
	@Ignore
	public void insertTest() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1L);
		vo.setReply("댓글 작업중 ....");
		vo.setReplyer("댓글러");
		int result = mapper.insert(vo);
		System.out.println("뭐가 찍히니? : " + result);
	}

	@Test
	@Ignore
	public void findByRnoTest() {
		System.out.println(mapper.read(10L));
	}

	@Test
	@Ignore
	public void deleteTest() {
		mapper.delete(14L);
	}

	@Test
	@Ignore
	public void updateTest() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(11L);
		vo.setReply("댓글작업 수정중....");
		mapper.update(vo);
		System.out.println(vo);
	}
	
	@Test
	public void getListWithPagingTest() {
		List<ReplyVO> listWithPaging=mapper.getListWithPaging(new Criteria(), 1L);
		System.out.println(listWithPaging);
	}
}
