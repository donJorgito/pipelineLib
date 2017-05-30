package cd

import com.cloudbees.groovy.cps.NonCPS

class Util implements Serializable {

    def conf
    def script
    def currentBuild

    Util(Object script) {
        this.script = script
        this.conf = [:]
        this.currentBuild = ''
    }

    Util(Object script, Map conf, String currentBuild) {
        this.script = script
        this.conf = conf
        this.currentBuild = currentBuild
    }

    @NonCPS
    def nonCPSExceptionHandler(e) {

        def rootCause = ''
        try {
            def w = new StringWriter();
            e.printStackTrace(new PrintWriter(w))
            rootCause = w.toString()
            w = null
        } catch (cpserr) {
            script.echo "StringWriter error: ${cpserr.getMessage()}"
        }
        return rootCause
    }

  def doFlowExceptionCatch(e) {

      script.node('agent') {
          script.echo "\033[35m Caugth exception ${e} \033[0m "
          def ROOTEXCEPTION = org.codehaus.groovy.runtime.StackTraceUtils.sanitizeRootCause(e)
          def rootCause = nonCPSExceptionHandler(e)

          script.writeFile file: 'ROOTEXCEPTION', text: "${ROOTEXCEPTION}\n ${rootCause}"
          script.archive 'ROOTEXCEPTION'

          if (e instanceof java.io.NotSerializableException ||
                  e instanceof groovy.lang.MissingPropertyException ||
                  e instanceof org.jenkinsci.plugins.scriptsecurity.sandbox.RejectedAccessException) {
              throw e
          }
          script.error "${e.message} \n${ROOTEXCEPTION}"
      }
  }
}
