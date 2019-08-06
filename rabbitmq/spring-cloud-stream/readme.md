rabbitmqctl add_vhost credit

rabbitmqctl set_permissions -p credit guest ".*" ".*" ".*"