<?php

interface Deployable 
{
    public function deploy();
}

class KubernetesDeployment implements Deployable
{
    public function deploy()
    {
        //
    }
}

class SwarmDeployment implements Deployable
{
    public function deploy()
    {
        //
    }
}

class Application
{
    public function deploy(Deployable $deployable)
    {
        $this->fireEvent('deploying');

        $deployable($this);
    }
}

(new Application())->deploy(new KubernetesDeployment());
