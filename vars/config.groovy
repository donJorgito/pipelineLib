import groovy.transform.Field

@Field agent = 'agent'
@Field enabled = false

def setAgent(v) {
    this.agent = v;
}
def getAgent() {
    return this.agent;
}

def setEnabled(v) {
    this.enabled = v;
}
def getEnabled() {
    return this.enabled;
}
