package jp.co.pnop.moris.azure.api.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;

@Component
public class AzureAuthenticateService {

    @Value("${subscriptionId}")
    private String _subscriptionId;

    @Value("${tenantId}")
    private String _tenantId;

    @Value("${clientId}")
    private String _clientId;

    @Value("${clientSecret}")
    private String _clientSecret;

    public Azure GetAzure() {

        var creds = new ApplicationTokenCredentials(_clientId, _tenantId, _clientSecret, null);
        var azure = Azure.configure()
                .authenticate(creds)
                .withSubscription(_subscriptionId);

        return azure;
    }
}
