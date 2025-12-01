-- dap_setup.lua
local dap = require("dap")
local dapgo = require("dap-go")

-- Lazy-load dap-ui only after dap-ui plugin is loaded
vim.defer_fn(function()
  local ok, dapui = pcall(require, "dapui")
  if ok then
    dapui.setup()
  end
end, 0)

dapgo.setup()

