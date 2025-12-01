-- lua/plugins.lua
local plugins = {
  -- Utilities
  { "nvim-lua/plenary.nvim" },
  { "nvim-tree/nvim-web-devicons" },

  -- Package manager helper
  {
    "williamboman/mason.nvim",
    config = function()
      require("mason").setup()
    end,
  },
  { "williamboman/mason-lspconfig.nvim" },

  -- LSP
  { "neovim/nvim-lspconfig" },

  -- Completion & snippets
  { "hrsh7th/nvim-cmp" },
  { "hrsh7th/cmp-nvim-lsp" },
  { "hrsh7th/cmp-buffer" },
  { "hrsh7th/cmp-path" },
  { "L3MON4D3/LuaSnip" },
  { "saadparwaiz1/cmp_luasnip" },

  -- Treesitter
  { "nvim-treesitter/nvim-treesitter", build = ":TSUpdate" },

  -- Formatter
  { "stevearc/conform.nvim" },

  -- DAP + Go adapter
  { "mfussenegger/nvim-dap" },
  { "leoluz/nvim-dap-go" },
  {
    "rcarriga/nvim-dap-ui",
    dependencies = { "nvim-neotest/nvim-nio" }, -- required for dap-ui
    config = function()
      require("dapui").setup()
    end,
  },

  -- Testing
  {
    "nvim-neotest/neotest",
    dependencies = { "nvim-neotest/nvim-nio" },
    config = function()
      require("neotest").setup({
        adapters = { require("neotest-go")({}) },
      })
    end,
  },
  { "nvim-neotest/neotest-go" },

  -- Telescope
  { "nvim-telescope/telescope.nvim" },

  -- File explorer (NvimTree)
  {
    "nvim-tree/nvim-tree.lua",
    dependencies = { "nvim-tree/nvim-web-devicons" },
    config = function()
      require("nvimtree_setup") -- call our lua/nvimtree_setup.lua
    end,
  },

  -- Status / UI
  { "nvim-lualine/lualine.nvim" },
  { "akinsho/bufferline.nvim" },
  { "folke/which-key.nvim" },
  { "rcarriga/nvim-notify" },

  -- Optional: go.nvim for Go-specific helpers
  { "ray-x/go.nvim" },
}

-- Setup all plugins with lazy.nvim
require("lazy").setup(plugins)
