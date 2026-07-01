K8s  
  
kubectl get events --sort-by='.metadata.creationTimestamp'  
kubectl get nodes -o wide  
kubectl exec -it opensearch-67f46fb6d6-vvdxk -- curl -v [http://localhost:9200](http://localhost:9200)  
  
kubectl run -i --tty --rm debug --image=busybox --restart=Never -- sh  
kubectl describe pod loki-0 -n logging  
  
Helm  curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash  
  
helm repo add grafana [https://grafana.github.io/helm-charts](https://grafana.github.io/helm-charts)  
  
helm repo update  
  
helm install loki grafana/loki-stack --namespace=logging --create-namespace  
  
helm install grafana grafana/grafana --namespace=logging --set "loki.enabled=true" --create-namespace  
  
kubectl port-forward svc/grafana 3000:80 --namespace=logging  
  
helm upgrade loki grafana/loki -n logging -f ./k8s/loki.yaml  
  
kubectl delete pod loki-0 -n logging helm upgrade --install loki grafana/loki -n logging -f values.yaml  
 curl -X POST -H "Content-Type: application/json" \ --data '{"streams":[{"stream":{"job":"example"},"values":[["'$(date +%s)'","Hello from Loki!"]]}]}' \ http://loki:3100/loki/api/v1/push   
If want to push system logs etc:  
helm install promtail grafana/promtail --namespace logging --create-namespace \ --set loki.serviceName=loki  
  
Add Loki datasource to grafana  
Localhost:3000  set lok url to http://loki:3100  
  
  
—  
  
NAME: grafana  
LAST DEPLOYED: Sat Jan 11 21:36:16 2025  
NAMESPACE: logging  
STATUS: deployed  
REVISION: 1  
NOTES:  
1. Get your 'admin' user password by running:  
  
   kubectl get secret --namespace logging grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo  
  
  
2. The Grafana server can be accessed via port 80 on the following DNS name from within your cluster:  
  
   grafana.logging.svc.cluster.local  
  
   Get the Grafana URL to visit by running these commands in the same shell:  
     export POD_NAME=$(kubectl get pods --namespace logging -l "app.kubernetes.io/name=grafana,app.kubernetes.io/instance=grafana" -o jsonpath="{.items[0].metadata.name}")  
     kubectl --namespace logging port-forward $POD_NAME 3000  
  
3. Login with the password from step 1 and the username: admin  
  
  
  
loki: storage_config: s3: bucket_names: - "your-bucket-name" access_key_id: "your-access-key" secret_access_key: "your-secret-key" endpoint: "s3.amazonaws.com" insecure: false  
  
promtail -config.file=promtail.yaml  
  
helm upgrade loki grafana/loki-stack --version 2.10.2 -n logging  
  
helm uninstall promtail -n logging  
helm upgrade loki grafana/loki-stack --set promtail.enabled=false -n logging  
helm list --namespace logging  
kubectl rollout restart statefulset loki -n logging  
  
  
Timetsmap issue  
  
helm list -n logging  
  
  
  
—  
  
  
helm install loki grafana/loki-stack --set loki.persistence.enabled=true --set loki.persistence.size=10Gi --set loki.persistence.storageClass=standard  
  
kubectl get pods -l app=loki  
  
helm install grafana grafana/grafana  
kubectl get pods -l app=grafana  
  
  
kubectl get secret --namespace default grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo  
  
kubectl get events --sort-by='.lastTimestamp'  
