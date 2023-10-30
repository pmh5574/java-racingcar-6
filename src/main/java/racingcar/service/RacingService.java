package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.util.StatusEnum;
import racingcar.domain.Cars;

public class RacingService {

    private final Cars cars;

    private static final int MOVE_CONDITION = 4;

    public RacingService(String carsName) {
        this.cars = new Cars(carsName);
    }

    public StatusEnum getMoveOrStop(int randomNum) {

        if (randomNum >= MOVE_CONDITION) {
            return StatusEnum.MOVE;
        }

        return StatusEnum.STOP;
    }

    public void racingStart() {
        cars.getCarList()
                .forEach(car -> {
                    StatusEnum statusEnum = getMoveOrStop(getRandomNum());
                    car.moveOrStop(statusEnum);
                });
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
