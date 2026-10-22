import copy


class ConfigManager:
    __config: dict[str, str]

    def __init__(self) -> None:
        self.__config = {}

    def set_config(self, key: str, value: str) -> None:
        self.__config[key] = value

    def get_config(self, key: str) -> str | None:
        return self.__config[key]

    def get_all_configs(self) -> dict[str, str]:
        return copy.copy(self.__config)


config_manager = ConfigManager()
