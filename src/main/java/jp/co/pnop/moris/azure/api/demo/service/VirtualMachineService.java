package jp.co.pnop.moris.azure.api.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.rest.ServiceCallback;

import jp.co.pnop.moris.azure.api.demo.model.IVirtualMachineListModel;
import jp.co.pnop.moris.azure.api.demo.model.impl.VirtualMachineListModel;

@Service
public class VirtualMachineService {

    private Logger _logger = LoggerFactory.getLogger(VirtualMachineService.class);

    @Autowired
    private AzureAuthenticateService _azureAuthService;

    public VirtualMachineService() {
    }

    public List<IVirtualMachineListModel> listVirtualMachies() {

        var list = new ArrayList<IVirtualMachineListModel>();

        for (VirtualMachine vm : _azureAuthService.GetAzure().virtualMachines().list()) {
            list.add(VirtualMachineListModel.NewInstance(vm));
        }
        return list;
    }

    @Async
	public void start(String id) {
        var vm = _azureAuthService.GetAzure().virtualMachines().getById(id);
        vm.startAsync(new ServiceCallback<Void>() {
            @Override
            public void success(Void result) {
                _logger.info("sucessfully started. {}", id);
            }

            @Override
            public void failure(Throwable t) {
                _logger.error("start failed.", t);
            }

        });
    }

    @Async
    public void deallocate(String id) {
        var vm = _azureAuthService.GetAzure().virtualMachines().getById(id);
        vm.deallocateAsync(new ServiceCallback<Void>() {
            @Override
            public void success(Void result) {
                _logger.info("successfully deallocated. {}", id);
            }

            @Override
            public void failure(Throwable t) {
                _logger.error("deallocation failed.", t);
            }
        });
        return;
    }

}
