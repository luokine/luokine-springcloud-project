package com.luokine.client;

import com.luokine.provider.api.service.ProviderApiService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:59
 */
@FeignClient(ProviderClientServicePKG.OPEN_SERVICE)
public interface ProviderClientService extends ProviderApiService {
}
