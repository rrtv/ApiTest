package mapper;

import model.PostCase;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostCaseMapper {

//    @Select("SELECT *FROM post_case WHERE ID= #{id}")
    public PostCase selectById(int id);

    public List<PostCase> selectAll();
}
