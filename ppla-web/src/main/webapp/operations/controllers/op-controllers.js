define([
  '/operations/controllers/AuthController.js',
  '/operations/controllers/WorkOrderBrowseController.js',
  '/operations/controllers/WorkOrderController.js',
  '/operations/controllers/WarehouseProcessController.js',
  '/operations/controllers/MixingProcessController.js',
  '/operations/controllers/ProfileController.js',

  //Mixer
  '/operations/modules/mixer/controllers/MixerController.js',
  '/operations/modules/mixer/controllers/MixerWorkorderController.js',
  '/operations/modules/mixer/controllers/MixerIdentityController.js',
  '/operations/modules/mixer/controllers/MixerMachineController.js',
  '/operations/modules/mixer/controllers/MixerMaterialsController.js',
  '/operations/modules/mixer/controllers/MixerAdditionalController.js',

  //Warehouse
  '/operations/modules/warehouse/controllers/WarehouseController.js',
  '/operations/modules/warehouse/controllers/WarehouseWorkorderController.js',
  '/operations/modules/warehouse/controllers/WarehouseIdentityController.js',
  '/operations/modules/warehouse/controllers/WarehouseMaterialsController.js',
  '/operations/modules/warehouse/controllers/WarehouseAdditionalController.js'
], function () {});