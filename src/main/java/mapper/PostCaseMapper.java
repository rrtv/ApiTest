package mapper;

import model.PostCase;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostCaseMapper {

    public String selectCase();

//    @Select("SELECT *FROM post_case WHERE ID= #{id}")
    public PostCase selectById(Long id);

    public List<PostCase> selectAll();
}
