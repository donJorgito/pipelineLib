def call() {

//def cfg = configFileProvider XX
return [
  'agent': cfg?.agent ?: 'agent',
  'enabled': false,
  ]

}
