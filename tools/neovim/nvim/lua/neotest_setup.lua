-- Safe lazy load for Neotest
vim.defer_fn(function()
  local ok, neotest = pcall(require, "neotest")
  if ok then
    neotest.setup({
      adapters = { require("neotest-go")({}) },
    })
  end
end, 0)

