def call(conf = [:], String element = '') {
  if (conf.conf != null) { //multiple named parameters passed
       element = conf.element
       conf = conf.conf
   }
   node ('agent') {
    input message: "Waiting for confirmation with ${element}", id: 'aInput', ok: 'Go on'
   }
}
