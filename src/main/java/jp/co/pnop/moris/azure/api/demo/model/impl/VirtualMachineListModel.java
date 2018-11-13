package jp.co.pnop.moris.azure.api.demo.model.impl;

import com.microsoft.azure.management.compute.VirtualMachine;

import jp.co.pnop.moris.azure.api.demo.model.IVirtualMachineListModel;

public class VirtualMachineListModel implements IVirtualMachineListModel {

    private String _id;
    private String _name;
    private String _region;
    private String _resourceGroupName;
    private String _status;

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public String getResourceGroupName() {
        return _resourceGroupName;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getRegionName() {
        return _region;
    }

    @Override
    public String getStatus() {
        return _status;
    }

    public static IVirtualMachineListModel NewInstance(VirtualMachine vm) {
        var model = new VirtualMachineListModel();
        model._id = vm.id();
        model._name = vm.name();
        model._region = vm.regionName();
        model._resourceGroupName = vm.resourceGroupName();
        if(vm.instanceView().statuses().size() > 1) {
            model._status = vm.instanceView().statuses().get(1).displayStatus();
        }
        return model;
    }
}
