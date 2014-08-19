define([
  '/operations/controllers/AuthController.js',
  '/operations/controllers/WorkOrderBrowseController.js',
  '/operations/controllers/WorkOrderController.js',
  '/operations/controllers/WarehouseProcessController.js',
  '/operations/controllers/MixingProcessController.js',
  '/operations/controllers/ProfileController.js',

  //Mixer start process
  '/operations/modules/mixer/controllers/startprocess/MixerController.js',
  '/operations/modules/mixer/controllers/startprocess/MixerWorkorderController.js',
  '/operations/modules/mixer/controllers/startprocess/MixerIdentityController.js',
  '/operations/modules/mixer/controllers/startprocess/MixerMachineController.js',
  '/operations/modules/mixer/controllers/startprocess/MixerMaterialsController.js',
  '/operations/modules/mixer/controllers/startprocess/MixerAdditionalController.js',

  //Mixer end process
  '/operations/modules/mixer/controllers/endprocess/MixerEndController.js',

  //Warehouse
  '/operations/modules/warehouse/controllers/WarehouseController.js',
  '/operations/modules/warehouse/controllers/WarehouseWorkorderController.js',
  '/operations/modules/warehouse/controllers/WarehouseIdentityController.js',
  '/operations/modules/warehouse/controllers/WarehouseMaterialsController.js',
  '/operations/modules/warehouse/controllers/WarehouseAdditionalController.js'
], function () {});