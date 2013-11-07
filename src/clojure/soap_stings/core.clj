(ns soap-stings.core)
(import com.zeus.soap.zxtm._1_0.VirtualServerLocator)
(import com.zeus.soap.zxtm._1_0.PoolLocator)
(import com.zeus.soap.zxtm._1_0.SystemLogLocator)

(defn list-virtual-servers
  "Lists virtual server names"
  []
  (let [l (doto (VirtualServerLocator.)
              (.setVirtualServerPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        vsp (.getVirtualServerPort l)
        vsnames (.getVirtualServerNames vsp)]
    vsnames))

(defn list-pool-names
  "Lists pool names"
  []
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        pool-names (.getPoolNames pp)]
    pool-names))

(defn list-draining-nodes
  "Lists draining nodes"
  [pool-names]
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        draining-nodes (.getDrainingNodes pp pool-names)]
    draining-nodes))

(defn list-draining-node
  "Lists draining nodes from single node"
  [pool-name]
  (list-draining-nodes (into-array String [pool-name])))

(defn add-nodes
  "Adds nodes to the pool. Usage: add-node pool [nodes]"
  [pool nodes]
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        pool-name (into-array String [pool])
        pool-nodes (into-array (map (partial into-array String) [nodes]))]

    (.addNodes pp pool-name pool-nodes)))

(defn add-node
  "Adds a node to the pool. Usage: add-node pool node"
  [pool node]
  (add-nodes pool [node]))

(defn get-nodes
  "Gets the nodes from a pool. Usage: get-nodes pool"
  [pool]
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        pool-name (into-array String [pool])]
    (.getNodes pp pool-name)))

(defn remove-nodes
  "Removes nodes from a pool. Usage: remove-nodes pool [nodes]"
  [pool nodes]
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        pool-name (into-array String [pool])
        pool-nodes (into-array (map (partial into-array String) [nodes]))]

    (.removeNodes pp pool-name pool-nodes)))

(defn remove-node
  "Removes a node from a pool. Usage: remove-nodes pool node"
  [pool node]
  (remove-nodes pool [node]))

(defn drain-nodes
  "Drains nodes in a pool. Usage: drain-nodes pool [nodes]"
  [pool nodes]
  (let [l (doto (PoolLocator.)
              (.setPoolPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        pp (.getPoolPort l)
        pool-name (into-array String [pool])
        pool-nodes (into-array (map (partial into-array String) [nodes]))]

    (.setDrainingNodes pp pool-name pool-nodes)))

(defn drain-node
  "Drains a node in a pool. Usage: drain-node pool node"
  [pool node]
  (drain-nodes pool [node]))

(defn error-log
  "Prints the error log"
  []
  (let [l (doto (SystemLogLocator.)
              (.setSystemLogPortEndpointAddress "http://admin:password@zeus.acme.com:9090/soap"))
        slp (.getSystemLogPort l)
        error (.getErrorLogString slp)]
    error))
