package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinqian.cloundprint.entity.Machine;
import dao.MachineMapper;
import org.springframework.stereotype.Service;
import service.IMachineService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengpan
 * @since 2020-10-12
 */
@Service
public class MachineServiceImpl extends ServiceImpl<MachineMapper, Machine> implements IMachineService {

}
