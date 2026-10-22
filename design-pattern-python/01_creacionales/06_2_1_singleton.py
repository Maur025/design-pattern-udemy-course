from singleton.config_manager import config_manager

config_manager.set_config("apiUrl", "http://localhost:3000/api")
config_manager.set_config("timeout", "5000")
config_manager.set_config("apiKey", "ABC123")

print(config_manager.get_config("apiUrl"))
print(config_manager.get_config("timeout"))
print(config_manager.get_config("apiKey"))
