local map = vim.keymap.set

-- Set leader
vim.g.mapleader = " "
vim.g.maplocalleader = ","

-- Telescope
map("n", "<leader>ff", "<cmd>Telescope find_files<cr>")
map("n", "<leader>fg", "<cmd>Telescope live_grep<cr>")
map("n", "<leader>fb", "<cmd>Telescope buffers<cr>")
map("n", "<leader>fr", "<cmd>Telescope oldfiles<cr>")

-- File explorer
map("n", "<leader>e", "<cmd>Oil<cr>")

-- vim.keymap.set("n", "<leader>e", ":NvimTreeToggle<CR>", { desc = "Toggle file explorer" })
-- vim.keymap.set("n", "<leader>r", ":NvimTreeRefresh<CR>", { desc = "Refresh file explorer" })
-- vim.keymap.set("n", "<leader>n", ":NvimTreeFindFile<CR>", { desc = "Focus current file in explorer" })

map("n", "<leader><leader>", ":NvimTreeToggle<CR>", { desc = "Toggle file explorer" })

-- LSP
map("n", "K", vim.lsp.buf.hover)
map("n", "gd", vim.lsp.buf.definition)
map("n", "gD", vim.lsp.buf.declaration)
map("n", "gi", vim.lsp.buf.implementation)
map("n", "<leader>rr", vim.lsp.buf.rename)
map("n", "<leader>ca", vim.lsp.buf.code_action)

-- Go
map("n", "<leader>gt", "<cmd>lua require('neotest').run.run()<cr>")
map("n", "<leader>gf", "<cmd>lua vim.lsp.buf.format({ async = true })<cr>")

-- DAP
map("n", "<F5>", "<cmd>lua require'dap'.continue()<cr>")
map("n", "<F10>", "<cmd>lua require'dap'.step_over()<cr>")
map("n", "<F11>", "<cmd>lua require'dap'.step_into()<cr>")
map("n", "<F12>", "<cmd>lua require'dap'.step_out()<cr>")

-- Convenience
map("n", "<leader>q", ":qa<CR>")

