package service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinqian.cloundprint.entity.Machineorder;
import dao.MachineorderMapper;
import org.springframework.stereotype.Service;
import service.IMachineorderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengpan
 * @since 2020-10-12
 */
@Service
public class MachineorderServiceImpl extends ServiceImpl<MachineorderMapper, Machineorder> implements IMachineorderService {

}
