package jp.co.pnop.moris.azure.api.demo.controller;

import java.io.Serializable;

public class OperationRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String _id;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
}
