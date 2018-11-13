# Azure VirtualMachine Operation Sample with Spring boot

[Japanese 日本語](./README.ja.md)

This sample is web application that operates virtual machines using Azure Management REST API with Spring Boot.

Only the following functions are implemented.

+ Listing virtual machines in your subscription.
+ Deallocating virtual machine.
+ Starting virtual machine.

## Requirements
+ Java 10.0 or later
+ Azure subscription
+ Azure command line tools 2.x (https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest&viewFallbackFrom=azure-cli-lates)


## Preparation

Login your subscription and check subscription id.

```
az login
az account show
```

Create service principal with `az ad sp` command.

```
az ad sp create-for-rbac --name ServicePrincipalName --password PASSWORD
```

You will get following output.

```json
{
  "appId": "application id(client id)",
  "displayName": "ServicePrincipalName",
  "name": "http://ServicePrincipalName",
  "password": "client secret",
  "tenant": "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX"
}
````
[Create an Azure service principal with Azure CLI](https://docs.microsoft.com/en-us/cli/azure/create-an-azure-service-principal-azure-cli?view=azure-cli-latest)



Create `src/main/resources/application.properties` file and set values.

```
subscriptionId=<<set your subscription id>>
tenantId=<<set your tenant id>>
clientId=<<set your client id>>
clientSecret=<<set your client secret>>
```

## Run

Execute the following command.

```
mvn spring-boot:run
```

You can access https://localhost:8080/ and virtual machine list will be displayed.
