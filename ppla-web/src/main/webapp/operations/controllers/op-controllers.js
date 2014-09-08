define([
  '/operations/controllers/AuthController.js',
  '/operations/controllers/WorkOrderBrowseController.js',
  '/operations/controllers/WorkOrderController.js',
  '/operations/controllers/WarehouseProcessController.js',
  '/operations/controllers/MixingProcessController.js',
  '/operations/controllers/ProfileController.js',

  //Mixer common
  '/operations/modules/mixer/controllers/MixerController.js',
  '/operations/modules/mixer/controllers/MixerIdentityController.js',
  '/operations/modules/mixer/controllers/MixerMachineController.js',

  //Mixer start process
  '/operations/modules/mixer/controllers/start/MixerStartController.js',
  '/operations/modules/mixer/controllers/start/MixerWorkorderController.js',
  '/operations/modules/mixer/controllers/start/MixerMaterialsController.js',
  '/operations/modules/mixer/controllers/start/MixerAdditionalController.js',

  //Mixer end process
  '/operations/modules/mixer/controllers/end/MixerEndController.js',
  '/operations/modules/mixer/controllers/end/MixerEndMaterialsController.js',
  '/operations/modules/mixer/controllers/end/MixerStageExtrusionController.js',

  //Extruder common
  '/operations/modules/extruder/controllers/ExtruderController.js',
  '/operations/modules/extruder/controllers/ExtruderIdentityController.js',
  '/operations/modules/extruder/controllers/ExtruderMachineController.js',

  //Extruder start process
  '/operations/modules/extruder/controllers/start/ExtruderStartController.js',
  '/operations/modules/extruder/controllers/start/ExtruderWorkorderController.js',
  '/operations/modules/extruder/controllers/start/ExtruderMaterialsController.js',
  '/operations/modules/extruder/controllers/start/ExtruderAdditionalController.js',

  //Extruder end process
  '/operations/modules/extruder/controllers/end/ExtruderEndController.js',
  '/operations/modules/extruder/controllers/end/ExtruderEndMaterialsController.js',

  //Warehouse
  '/operations/modules/warehouse/controllers/WarehouseController.js',
  '/operations/modules/warehouse/controllers/WarehouseWorkorderController.js',
  '/operations/modules/warehouse/controllers/WarehouseIdentityController.js',
  '/operations/modules/warehouse/controllers/WarehouseMaterialsController.js',
  '/operations/modules/warehouse/controllers/WarehouseAdditionalController.js'
], function () {});