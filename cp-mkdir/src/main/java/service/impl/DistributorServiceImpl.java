package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinqian.cloundprint.entity.Distributor;
import dao.DistributorMapper;
import org.springframework.stereotype.Service;
import service.IDistributorService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengpan
 * @since 2020-10-12
 */
@Service
public class DistributorServiceImpl extends ServiceImpl<DistributorMapper, Distributor> implements IDistributorService {

}
