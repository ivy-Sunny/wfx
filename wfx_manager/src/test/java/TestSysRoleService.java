import com.ivy.entity.SysRole;
import com.ivy.service.SysRoleService;
import com.ivy.vo.TreeNodeVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * TestSysRoleService
 *
 * @Author: ivy
 * @CreateTime: 2021-07-15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class TestSysRoleService {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void findAll() {
        List<SysRole> list = sysRoleService.findAll();
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void findTree() {
        List<TreeNodeVO> tree = sysRoleService.findTree("11121");
        System.out.println(tree);
    }
}
