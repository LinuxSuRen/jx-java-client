package io.jenkins.x.client;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author suren
 */
public class JenkinsClient {
    public Secret getSecret() {
        KubernetesClient client = new DefaultKubernetesClient();
        String ns = client.getNamespace();

        return client.secrets().inNamespace(ns).withName("jenkins").get();
    }
}