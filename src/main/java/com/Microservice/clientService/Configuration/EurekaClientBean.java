package com.Microservice.clientService.Configuration;

import com.netflix.discovery.shared.transport.EurekaTransportConfig;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.core.env.PropertyResolver;

import java.util.List;
import java.util.Map;

public class EurekaClientBean extends EurekaClientConfigBean {

    /**Devuelve el host del proxy utilizado por el cliente Eureka.*/
    @Override
    public String getProxyHost() {
        return super.getProxyHost();
    }

    /**Establece el host del proxy que el cliente Eureka utilizará*/
    @Override
    public void setProxyHost(String proxyHost) {
        super.setProxyHost(proxyHost);
    }

    /**Devuelve el nombre de usuario del proxy utilizado por el cliente Eureka.*/
    @Override
    public String getProxyUserName() {
        return super.getProxyUserName();
    }

    /**Establece el nombre de usuario del proxy que el cliente Eureka utilizará.*/
    @Override
    public void setProxyUserName(String proxyUserName) {
        super.setProxyUserName(proxyUserName);
    }

    /**Devuelve la contraseña del proxy utilizada por el cliente Eureka*/
    @Override
    public String getProxyPassword() {
        return super.getProxyPassword();
    }

    /**Establece la contraseña del proxy que el cliente Eureka utilizará.*/
    @Override
    public void setProxyPassword(String proxyPassword) {
        super.setProxyPassword(proxyPassword);
    }

    /**Devuelve el tiempo de espera de lectura del servidor Eureka.*/
    @Override
    public int getEurekaServerReadTimeoutSeconds() {
        return super.getEurekaServerReadTimeoutSeconds();
    }

    /**Establece el tiempo de espera de lectura del servidor Eureka.*/
    @Override
    public void setEurekaServerReadTimeoutSeconds(int eurekaServerReadTimeoutSeconds) {
        super.setEurekaServerReadTimeoutSeconds(eurekaServerReadTimeoutSeconds);
    }

    /**Devuelve el tiempo de espera de conexión al servidor Eureka.*/
    @Override
    public int getEurekaServerConnectTimeoutSeconds() {
        return super.getEurekaServerConnectTimeoutSeconds();
    }

    /**Establece el tiempo de espera de conexión al servidor Eureka.*/
    @Override
    public void setEurekaServerConnectTimeoutSeconds(int eurekaServerConnectTimeoutSeconds) {
        super.setEurekaServerConnectTimeoutSeconds(eurekaServerConnectTimeoutSeconds);
    }

    /**Devuelve la implementación de respaldo del registro utilizado por el cliente Eureka.*/
    @Override
    public String getBackupRegistryImpl() {
        return super.getBackupRegistryImpl();
    }

    /**Establece la implementación de respaldo del registro que el cliente Eureka utilizará.*/
    @Override
    public void setBackupRegistryImpl(String backupRegistryImpl) {
        super.setBackupRegistryImpl(backupRegistryImpl);
    }

    /**Devuelve el número total de conexiones al servidor Eureka.*/
    @Override
    public int getEurekaServerTotalConnections() {
        return super.getEurekaServerTotalConnections();
    }

    /**Establece el número total de conexiones al servidor Eureka.*/
    @Override
    public void setEurekaServerTotalConnections(int eurekaServerTotalConnections) {
        super.setEurekaServerTotalConnections(eurekaServerTotalConnections);
    }

    /**Devuelve el número total de conexiones por host al servidor Eureka.*/
    @Override
    public int getEurekaServerTotalConnectionsPerHost() {
        return super.getEurekaServerTotalConnectionsPerHost();
    }

    /***/
    @Override
    public void setEurekaServerTotalConnectionsPerHost(int eurekaServerTotalConnectionsPerHost) {
        super.setEurekaServerTotalConnectionsPerHost(eurekaServerTotalConnectionsPerHost);
    }

    /**Establece el número total de conexiones por host al servidor Eureka.*/
    @Override
    public String getEurekaServerURLContext() {
        return super.getEurekaServerURLContext();
    }

    /**Devuelve el contexto de la URL del servidor Eureka*/
    @Override
    public void setEurekaServerURLContext(String eurekaServerURLContext) {
        super.setEurekaServerURLContext(eurekaServerURLContext);
    }

    /**Establece el contexto de la URL del servidor Eureka.*/
    @Override
    public String getEurekaServerPort() {
        return super.getEurekaServerPort();
    }

    /**Devuelve el puerto del servidor Eureka.*/
    @Override
    public void setEurekaServerPort(String eurekaServerPort) {
        super.setEurekaServerPort(eurekaServerPort);
    }

    /**Establece el puerto del servidor Eureka.*/
    @Override
    public String getEurekaServerDNSName() {
        return super.getEurekaServerDNSName();
    }

    /**Devuelve el nombre DNS del servidor Eureka.*/
    @Override
    public void setEurekaServerDNSName(String eurekaServerDNSName) {
        super.setEurekaServerDNSName(eurekaServerDNSName);
    }

    /**Establece el nombre DNS del servidor Eureka.*/
    @Override
    public String getRegion() {
        return super.getRegion();
    }
    /**Devuelve la región del cliente Eureka.*/
    @Override
    public void setRegion(String region) {
        super.setRegion(region);
    }
    /**Establece la región del cliente Eureka.*/
    @Override
    public int getEurekaConnectionIdleTimeoutSeconds() {
        return super.getEurekaConnectionIdleTimeoutSeconds();
    }
    /** Devuelve el tiempo de espera inactivo de la conexión Eureka.*/
    @Override
    public void setEurekaConnectionIdleTimeoutSeconds(int eurekaConnectionIdleTimeoutSeconds) {
        super.setEurekaConnectionIdleTimeoutSeconds(eurekaConnectionIdleTimeoutSeconds);
    }
    /**Devuelve la dirección VIP de actualización del registro.*/
    @Override
    public String getRegistryRefreshSingleVipAddress() {
        return super.getRegistryRefreshSingleVipAddress();
    }
    /**Establece la dirección VIP de actualización del registro*/
    @Override
    public void setRegistryRefreshSingleVipAddress(String registryRefreshSingleVipAddress) {
        super.setRegistryRefreshSingleVipAddress(registryRefreshSingleVipAddress);
    }
    /**Devuelve el tamaño del pool de hilos del ejecutor de latidos.*/
    @Override
    public int getHeartbeatExecutorThreadPoolSize() {
        return super.getHeartbeatExecutorThreadPoolSize();
    }
    /**Establece el tamaño del pool de hilos del ejecutor de latidos.*/
    @Override
    public void setHeartbeatExecutorThreadPoolSize(int heartbeatExecutorThreadPoolSize) {
        super.setHeartbeatExecutorThreadPoolSize(heartbeatExecutorThreadPoolSize);
    }
    /**Devuelve el límite de retroceso exponencial del ejecutor de latidos.*/
    @Override
    public int getHeartbeatExecutorExponentialBackOffBound() {
        return super.getHeartbeatExecutorExponentialBackOffBound();
    }
    /**Establece el límite de retroceso exponencial del ejecutor de latidos.*/
    @Override
    public void setHeartbeatExecutorExponentialBackOffBound(int heartbeatExecutorExponentialBackOffBound) {
        super.setHeartbeatExecutorExponentialBackOffBound(heartbeatExecutorExponentialBackOffBound);
    }
    /**Devuelve el tamaño del pool de hilos del ejecutor de actualización de caché.*/
    @Override
    public int getCacheRefreshExecutorThreadPoolSize() {
        return super.getCacheRefreshExecutorThreadPoolSize();
    }
    /**Establece el tamaño del pool de hilos del ejecutor de actualización de caché.
     */
    @Override
    public void setCacheRefreshExecutorThreadPoolSize(int cacheRefreshExecutorThreadPoolSize) {
        super.setCacheRefreshExecutorThreadPoolSize(cacheRefreshExecutorThreadPoolSize);
    }
    /**Devuelve el límite de retroceso exponencial del ejecutor de actualización de caché.*/
    @Override
    public int getCacheRefreshExecutorExponentialBackOffBound() {
        return super.getCacheRefreshExecutorExponentialBackOffBound();
    }
    /** Establece el límite de retroceso exponencial del ejecutor de actualización de caché.*/
    @Override
    public void setCacheRefreshExecutorExponentialBackOffBound(int cacheRefreshExecutorExponentialBackOffBound) {
        super.setCacheRefreshExecutorExponentialBackOffBound(cacheRefreshExecutorExponentialBackOffBound);
    }
    /**Devuelve las URL de servicio del cliente Eureka.*/
    @Override
    public Map<String, String> getServiceUrl() {
        return super.getServiceUrl();
    }
    /**Establece las URL de servicio del cliente Eureka.*/
    @Override
    public void setServiceUrl(Map<String, String> serviceUrl) {
        super.setServiceUrl(serviceUrl);
    }
    /**Devuelve true si el contenido está comprimido con gzip, false de lo contrario.*/
    @Override
    public boolean isgZipContent() {
        return super.isgZipContent();
    }
    /**Establece si el contenido debe comprimirse con gzip.*/
    @Override
    public void setgZipContent(boolean gZipContent) {
        super.setgZipContent(gZipContent);
    }
    /** Devuelve true si se debe utilizar DNS para obtener las URL de servicio, false de lo contrario.*/
    @Override
    public boolean isUseDnsForFetchingServiceUrls() {
        return super.isUseDnsForFetchingServiceUrls();
    }
    /**Establece si se debe utilizar DNS para obtener las URL de servicio.*/
    @Override
    public void setUseDnsForFetchingServiceUrls(boolean useDnsForFetchingServiceUrls) {
        super.setUseDnsForFetchingServiceUrls(useDnsForFetchingServiceUrls);
    }
    /**Devuelve true si el cliente se registrará con Eureka, false de lo contrario.*/
    @Override
    public boolean isRegisterWithEureka() {
        return super.isRegisterWithEureka();
    }

    @Override
    public void setRegisterWithEureka(boolean registerWithEureka) {
        super.setRegisterWithEureka(registerWithEureka);
    }

    @Override
    public boolean isPreferSameZoneEureka() {
        return super.isPreferSameZoneEureka();
    }

    @Override
    public void setPreferSameZoneEureka(boolean preferSameZoneEureka) {
        super.setPreferSameZoneEureka(preferSameZoneEureka);
    }

    @Override
    public boolean isLogDeltaDiff() {
        return super.isLogDeltaDiff();
    }

    @Override
    public void setLogDeltaDiff(boolean logDeltaDiff) {
        super.setLogDeltaDiff(logDeltaDiff);
    }

    @Override
    public boolean isDisableDelta() {
        return super.isDisableDelta();
    }

    @Override
    public void setDisableDelta(boolean disableDelta) {
        super.setDisableDelta(disableDelta);
    }

    @Override
    public String getFetchRemoteRegionsRegistry() {
        return super.getFetchRemoteRegionsRegistry();
    }

    @Override
    public void setFetchRemoteRegionsRegistry(String fetchRemoteRegionsRegistry) {
        super.setFetchRemoteRegionsRegistry(fetchRemoteRegionsRegistry);
    }

    @Override
    public Map<String, String> getAvailabilityZones() {
        return super.getAvailabilityZones();
    }

    @Override
    public void setAvailabilityZones(Map<String, String> availabilityZones) {
        super.setAvailabilityZones(availabilityZones);
    }

    @Override
    public boolean isFilterOnlyUpInstances() {
        return super.isFilterOnlyUpInstances();
    }

    @Override
    public void setFilterOnlyUpInstances(boolean filterOnlyUpInstances) {
        super.setFilterOnlyUpInstances(filterOnlyUpInstances);
    }

    @Override
    public boolean isFetchRegistry() {
        return super.isFetchRegistry();
    }

    @Override
    public void setFetchRegistry(boolean fetchRegistry) {
        super.setFetchRegistry(fetchRegistry);
    }

    @Override
    public String getDollarReplacement() {
        return super.getDollarReplacement();
    }

    @Override
    public void setDollarReplacement(String dollarReplacement) {
        super.setDollarReplacement(dollarReplacement);
    }

    @Override
    public String getEscapeCharReplacement() {
        return super.getEscapeCharReplacement();
    }

    @Override
    public void setEscapeCharReplacement(String escapeCharReplacement) {
        super.setEscapeCharReplacement(escapeCharReplacement);
    }

    @Override
    public boolean isAllowRedirects() {
        return super.isAllowRedirects();
    }

    @Override
    public void setAllowRedirects(boolean allowRedirects) {
        super.setAllowRedirects(allowRedirects);
    }

    @Override
    public boolean isOnDemandUpdateStatusChange() {
        return super.isOnDemandUpdateStatusChange();
    }

    @Override
    public void setOnDemandUpdateStatusChange(boolean onDemandUpdateStatusChange) {
        super.setOnDemandUpdateStatusChange(onDemandUpdateStatusChange);
    }

    @Override
    public String getEncoderName() {
        return super.getEncoderName();
    }

    @Override
    public void setEncoderName(String encoderName) {
        super.setEncoderName(encoderName);
    }

    @Override
    public String getDecoderName() {
        return super.getDecoderName();
    }

    @Override
    public void setDecoderName(String decoderName) {
        super.setDecoderName(decoderName);
    }

    @Override
    public String getClientDataAccept() {
        return super.getClientDataAccept();
    }

    @Override
    public void setClientDataAccept(String clientDataAccept) {
        super.setClientDataAccept(clientDataAccept);
    }

    @Override
    public boolean isShouldUnregisterOnShutdown() {
        return super.isShouldUnregisterOnShutdown();
    }

    @Override
    public void setShouldUnregisterOnShutdown(boolean shouldUnregisterOnShutdown) {
        super.setShouldUnregisterOnShutdown(shouldUnregisterOnShutdown);
    }

    @Override
    public boolean isShouldEnforceRegistrationAtInit() {
        return super.isShouldEnforceRegistrationAtInit();
    }

    @Override
    public void setShouldEnforceRegistrationAtInit(boolean shouldEnforceRegistrationAtInit) {
        super.setShouldEnforceRegistrationAtInit(shouldEnforceRegistrationAtInit);
    }

    @Override
    public int getOrder() {
        return super.getOrder();
    }

    @Override
    public void setOrder(int order) {
        super.setOrder(order);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public boolean shouldGZipContent() {
        return super.shouldGZipContent();
    }

    @Override
    public boolean shouldUseDnsForFetchingServiceUrls() {
        return super.shouldUseDnsForFetchingServiceUrls();
    }

    @Override
    public boolean shouldRegisterWithEureka() {
        return super.shouldRegisterWithEureka();
    }

    @Override
    public boolean shouldPreferSameZoneEureka() {
        return super.shouldPreferSameZoneEureka();
    }

    @Override
    public boolean shouldLogDeltaDiff() {
        return super.shouldLogDeltaDiff();
    }

    @Override
    public boolean shouldDisableDelta() {
        return super.shouldDisableDelta();
    }

    @Override
    public boolean shouldUnregisterOnShutdown() {
        return super.shouldUnregisterOnShutdown();
    }

    @Override
    public boolean shouldEnforceRegistrationAtInit() {
        return super.shouldEnforceRegistrationAtInit();
    }

    @Override
    public String fetchRegistryForRemoteRegions() {
        return super.fetchRegistryForRemoteRegions();
    }

    @Override
    public String[] getAvailabilityZones(String region) {
        return super.getAvailabilityZones(region);
    }

    @Override
    public List<String> getEurekaServerServiceUrls(String myZone) {
        return super.getEurekaServerServiceUrls(myZone);
    }

    @Override
    public boolean shouldFilterOnlyUpInstances() {
        return super.shouldFilterOnlyUpInstances();
    }

    @Override
    public boolean shouldFetchRegistry() {
        return super.shouldFetchRegistry();
    }

    @Override
    public boolean allowRedirects() {
        return super.allowRedirects();
    }

    @Override
    public boolean shouldOnDemandUpdateStatusChange() {
        return super.shouldOnDemandUpdateStatusChange();
    }

    @Override
    public String getExperimental(String name) {
        return super.getExperimental(name);
    }

    @Override
    public EurekaTransportConfig getTransportConfig() {
        return super.getTransportConfig();
    }

    @Override
    public PropertyResolver getPropertyResolver() {
        return super.getPropertyResolver();
    }

    @Override
    public void setPropertyResolver(PropertyResolver propertyResolver) {
        super.setPropertyResolver(propertyResolver);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public EurekaTransportConfig getTransport() {
        return super.getTransport();
    }

    @Override
    public void setTransport(EurekaTransportConfig transport) {
        super.setTransport(transport);
    }

    @Override
    public int getRegistryFetchIntervalSeconds() {
        return super.getRegistryFetchIntervalSeconds();
    }

    @Override
    public void setRegistryFetchIntervalSeconds(int registryFetchIntervalSeconds) {
        super.setRegistryFetchIntervalSeconds(registryFetchIntervalSeconds);
    }

    @Override
    public int getInstanceInfoReplicationIntervalSeconds() {
        return super.getInstanceInfoReplicationIntervalSeconds();
    }

    @Override
    public void setInstanceInfoReplicationIntervalSeconds(int instanceInfoReplicationIntervalSeconds) {
        super.setInstanceInfoReplicationIntervalSeconds(instanceInfoReplicationIntervalSeconds);
    }

    @Override
    public int getInitialInstanceInfoReplicationIntervalSeconds() {
        return super.getInitialInstanceInfoReplicationIntervalSeconds();
    }

    @Override
    public void setInitialInstanceInfoReplicationIntervalSeconds(int initialInstanceInfoReplicationIntervalSeconds) {
        super.setInitialInstanceInfoReplicationIntervalSeconds(initialInstanceInfoReplicationIntervalSeconds);
    }

    @Override
    public int getEurekaServiceUrlPollIntervalSeconds() {
        return super.getEurekaServiceUrlPollIntervalSeconds();
    }

    @Override
    public void setEurekaServiceUrlPollIntervalSeconds(int eurekaServiceUrlPollIntervalSeconds) {
        super.setEurekaServiceUrlPollIntervalSeconds(eurekaServiceUrlPollIntervalSeconds);
    }

    @Override
    public String getProxyPort() {
        return super.getProxyPort();
    }

    @Override
    public void setProxyPort(String proxyPort) {
        super.setProxyPort(proxyPort);
    }
}
