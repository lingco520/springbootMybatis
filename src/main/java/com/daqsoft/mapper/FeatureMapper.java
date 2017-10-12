/**
 * @Copyright: <a htef="http://www.daqsoft.com
 * <p>
 * ">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
package com.daqsoft.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Title: ParkingMapper
 * @Author: tanggm
 * @Date: 2017/10/09 13:54
 * @Description: TODO
 * @Comment：
 * @see
 * @Version:
 * @since JDK 1.8
 * @Warning:
 */
@Repository
public interface FeatureMapper {

    List<Map> getMenu(Integer pid);
}
